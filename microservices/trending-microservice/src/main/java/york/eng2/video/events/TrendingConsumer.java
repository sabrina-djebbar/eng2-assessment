package york.eng2.video.events;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import york.eng2.video.domain.Video;

@KafkaListener
public class TrendingConsumer {
	/*
	 * @Topic(BooksStreams.TOPIC_READ_BY_DAY) public void bookReadMetric(@KafkaKey
	 * WindowedIdentifier window, Long count) {
	 * System.out.printf("New value for key %s: %d%n", window, count); }
	 */

	@Topic(VideosProducer.TOPIC_POST)
	public void postedVideo(@KafkaKey Long id, Video video) {
		System.out.printf("video posted: %d%n", id);
	}
}
