package york.eng2.subscription.events;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import york.eng2.subscription.domain.Hashtag;

@KafkaClient
public interface SubscriptionProducer {
	String TOPIC_USER_SUBSCRIBE = "user-subscribe";
	String TOPIC_USER_UNSUBSCRIBE = "user-unsubscribe";

	@Topic(TOPIC_USER_SUBSCRIBE)
	void subscribeToHashtag(@KafkaKey Long id, Hashtag hashtag);

	@Topic(TOPIC_USER_UNSUBSCRIBE)
	void unsubscribeToHashtag(@KafkaKey Long id, Hashtag hashtag);
}
