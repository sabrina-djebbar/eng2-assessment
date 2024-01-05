package york.eng2.trending.events;

import java.time.Duration;
import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.TimeWindows;

import io.micronaut.configuration.kafka.serde.SerdeRegistry;
import io.micronaut.configuration.kafka.streams.ConfiguredStreamBuilder;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import york.eng2.trending.domain.Hashtag;

@Factory
public class TrendingStreams {
	public static final String TOPIC_MOST_LIKED_BY_HOUR = "most-liked-by-hour";

	@Inject
	private SerdeRegistry serdeRegistry;

	@Singleton
	public KStream<WindowedIdentifier, Long> likedByDay(ConfiguredStreamBuilder builder) {
		Properties props = builder.getConfiguration();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "trending-metrics");

		props.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.EXACTLY_ONCE);

		KStream<Long, Hashtag> trendingStream = builder.stream("video-like",
				Consumed.with(Serdes.Long(), serdeRegistry.getSerde(Hashtag.class)));

		KStream<WindowedIdentifier, Long> stream = trendingStream.groupByKey()
				.windowedBy(TimeWindows.of(Duration.ofHours(1)).advanceBy(Duration.ofHours(1)))
				.count(Materialized.as("liked-by-hour")).toStream()
				.selectKey((k, v) -> new WindowedIdentifier(k.key(), k.window().start(), k.window().end()));

		stream.to(TOPIC_MOST_LIKED_BY_HOUR,
				Produced.with(serdeRegistry.getSerde(WindowedIdentifier.class), Serdes.Long()));

		return stream;
	}

}
