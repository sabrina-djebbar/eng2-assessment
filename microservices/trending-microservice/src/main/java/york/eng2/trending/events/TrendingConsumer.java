package york.eng2.trending.events;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import jakarta.inject.Inject;
import york.eng2.trending.domain.Video;
import york.eng2.trending.repositories.HashtagsRepository;

@KafkaListener(groupId = "video-debug")
public class TrendingConsumer {
	@Inject
	HashtagsRepository repo;

	@Topic("video-post")
	public void postVideo(@KafkaKey Long id, Video video) {
		/*
		 * String[] tags = video.getTags(); for (String tag : tags) { Optional<Hashtag>
		 * hashtag = repo.findByName(tag); if (hashtag.isEmpty()) { Hashtag newTag = new
		 * Hashtag(); newTag.setName(tag); System.out.printf("tags ", tags);
		 * repo.save(newTag); } }
		 */
		System.out.printf("video posted: %d%n", id);
	}
}
