package york.eng2.subscription.events;

import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import york.eng2.subscription.domain.Hashtag;

public interface SubscriptionProducer {
	String TOPIC_USER_SUBSCRIBE = "user-subscribe";
	String TOPIC_USER_UNSUBSCRIBE = "user-unsubscribe";

	@Topic(TOPIC_USER_SUBSCRIBE)
	void postVideo(@KafkaKey Long userId, Hashtag hashtag);

	@Topic(TOPIC_USER_UNSUBSCRIBE)
	void postVideoV2(@KafkaKey Long userId, Hashtag hashtag);
}
