package york.eng2.trending.events;

import java.util.Optional;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import jakarta.inject.Inject;
import york.eng2.trending.domain.Hashtag;
import york.eng2.trending.dto.VideoDTO;
import york.eng2.trending.repositories.HashtagsRepository;

@KafkaListener(groupId = "trending-debug")
public class TrendingConsumer {
	@Inject
	HashtagsRepository repo;

	@Topic("video-post")
	public void postVideo(@KafkaKey Long id, VideoDTO video) {
		String[] tags = video.getTags().split(",");
		for (String tag : tags) {
			Optional<Hashtag> hashtag = repo.findByName(tag);

			if (hashtag.isEmpty()) {
				Hashtag newTag = new Hashtag();
				newTag.setName(tag);
				repo.save(newTag);
			}
		}

		System.out.printf("video posted: %d%n", id);
	}

	@Topic(TrendingStreams.TOPIC_MOST_LIKED_BY_HOUR)
	public void videoLikedMetric(@KafkaKey WindowedIdentifier window, Hashtag hashtag) {
		System.out.printf("New value for key %s%n", window);
	}

	@Topic("video-like")
	public void likeVideo(@KafkaKey Long id, Hashtag tag) {
		Optional<Hashtag> hashtag = repo.findByName(tag.getName());
		if (hashtag.isEmpty()) {
			System.out.printf("The tag " + tag.getName() + " could not be found");
			return;
		}

		System.out.printf("video liked: %d %s%n", id, tag.getName());

	}

	@Topic("video-dislike")
	public void dislikeVideo(@KafkaKey Long id, Long userId) {
		System.out.printf("video disliked: %d%n", id);
	}

	@Topic("video-watch")
	public void watchVideo(@KafkaKey Long id, Long userId) {
		System.out.printf("video watched: %d%n", id);
	}

}
