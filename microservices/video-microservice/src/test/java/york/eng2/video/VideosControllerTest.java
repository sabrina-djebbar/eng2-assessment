package york.eng2.video;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import york.eng2.video.clients.VideosClient;
import york.eng2.video.repositories.VideosRepository;

@MicronautTest
public class VideosControllerTest {
	@Inject
	VideosClient client;

	@Inject
	VideosRepository repo;

	@BeforeEach
	public void clean() {
		repo.deleteAll();
	}

	@Test
	public void noVideos() {
		Iterable<Video> iterVideoIterable = client.list()
	}
}
