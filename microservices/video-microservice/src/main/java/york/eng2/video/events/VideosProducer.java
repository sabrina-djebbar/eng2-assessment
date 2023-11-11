package york.eng2.video.events;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import york.eng2.video.domain.Video;

@KafkaClient
public interface VideosProducer {

	String TOPIC_POST = "video-post";
	String TOPIC_WATCH = "video-post";
	String TOPIC_LIKE = "video-post";
	String TOPIC_DISLIKE = "video-post";

	@Topic(TOPIC_POST)
	void postVideo(@KafkaKey Long id, Video video);

	@Topic(TOPIC_WATCH)
	void watchVideo(@KafkaKey Long id, String userId);

	@Topic(TOPIC_LIKE)
	void likeVideo(@KafkaKey Long id, Video video);

	@Topic(TOPIC_DISLIKE)
	void dislikeVideo(@KafkaKey Long id, Video video);
}
