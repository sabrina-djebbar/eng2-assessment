package york.eng2.trending.events;

import java.util.Optional;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import jakarta.inject.Inject;
import york.eng2.trending.domain.Hashtag;
import york.eng2.trending.domain.Video;
import york.eng2.trending.repositories.HashtagsRepository;

@KafkaListener(groupId = "video-debug")
public class TrendingConsumer {
	@Inject
	HashtagsRepository repo;

	@Topic("video-post")
	public void postVideo(@KafkaKey Long id, Video video) {

		String[] tags = video.getTags();
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

	@Topic("video-like")
	public void likeVideo(@KafkaKey Long id, Video video) {

		System.out.printf("video liked: %d%n", id);
	}

	@Topic("video-dislike")
	public void dislikeVideo(@KafkaKey Long id, Video video) {

		System.out.printf("video disliked: %d%n", id);
	}
}