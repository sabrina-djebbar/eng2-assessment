package york.eng2.subscription.events;

import java.util.Optional;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import jakarta.inject.Inject;
import york.eng2.subscription.domain.Hashtag;
import york.eng2.subscription.domain.User;
import york.eng2.subscription.domain.Video;
import york.eng2.subscription.dto.VideoDTO;
import york.eng2.subscription.repositories.HashtagsRepository;
import york.eng2.subscription.repositories.UsersRepository;
import york.eng2.subscription.repositories.VideosRepository;

@KafkaListener(groupId = "subscription-debug")
public class SubscriptionConsumer {
	@Inject
	VideosRepository videoRepo;

	@Inject
	UsersRepository userRepo;

	@Inject
	HashtagsRepository hashtagRepo;

	@Inject
	SubscriptionProducer producer;

	private User getUser(String username) {
		Optional<User> user = userRepo.findByUsername(username);
		if (user.isEmpty()) {
			User newUser = new User();
			newUser.setUsername(username);
			userRepo.save(newUser);
			return newUser;
		}
		return user.get();
	}

	private Hashtag getHashtag(String hashtag) {
		Optional<Hashtag> tag = hashtagRepo.findByName(hashtag);
		if (tag.isEmpty()) {
			Hashtag newTag = new Hashtag();
			newTag.setName(hashtag);
			hashtagRepo.save(newTag);
			return newTag;
		}
		return tag.get();
	}

	@Topic("video-post")
	public void postVideo(@KafkaKey Long id, VideoDTO videoDetails) {
		Video video = new Video();
		video.setTitle(videoDetails.getTitle());

		String[] hashtags = videoDetails.getTags().split(",");
		for (String hashtag : hashtags) {
			Hashtag tag = getHashtag(hashtag);
			System.out.println("hashtag" + tag);
			video.setHashtags(tag);
		}

		User user = getUser(videoDetails.getUsername());
		video.setUser(user);

		videoRepo.save(video);
	}

	@Topic("video-watch")
	public void watchVideo(@KafkaKey Long id, String username) {
		Optional<Video> v = videoRepo.findById(id);
		if (v.isEmpty()) {
			System.out.printf("Video not found");
			return;
		}
		Video video = v.get();
		User user = getUser(username);
		video.setViews(user);
		videoRepo.update(video);
		System.out.printf("video %d watched by user %s%n", id, username);
	}

	@Topic(SubscriptionProducer.TOPIC_USER_SUBSCRIBE)
	public void userSubscribe(@KafkaKey Long id, Hashtag tag) {
		String tagName = tag.getName();
		Optional<Hashtag> hashtag = hashtagRepo.findByName(tagName);
		if (hashtag.isEmpty()) {
			System.out.printf("The tag " + tagName + " could not be found");
			return;
		}

		System.out.printf("user %d subscribed to hashtag %s%n", id, tagName);

	}

	@Topic(SubscriptionProducer.TOPIC_USER_UNSUBSCRIBE)
	public void userUnsubscribe(@KafkaKey Long id, Hashtag tag) {
		String tagName = tag.getName();
		Optional<Hashtag> hashtag = hashtagRepo.findByName(tagName);
		if (hashtag.isEmpty()) {
			System.out.printf("The tag " + tagName + " could not be found");
			return;
		}

		System.out.printf("user %d unsubscribed to hashtag %s%n", id, tagName);

	}

	@Topic(SubscriptionStreams.TOPIC_VIEWS_BY_HOUR)
	public void hashtagsSubscribedMetric(@KafkaKey WindowedIdentifier window, Long count) {
		System.out.printf("New value for key %s: %d%n", window, count);
	}
}
