package york.eng2.video;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import york.eng2.video.clients.VideosClient;
import york.eng2.video.domain.Hashtag;
import york.eng2.video.domain.Video;
import york.eng2.video.dto.VideoDTO;
import york.eng2.video.events.VideosProducer;
import york.eng2.video.repositories.VideosRepository;

@MicronautTest(transactional = false)
public class VideosControllerTest {
	@Inject
	VideosClient client;

	@Inject
	VideosRepository repo;

	private final Map<Long, VideoDTO> postVideo = new HashMap<>();
	private final Map<Long, Hashtag> likeVideo = new HashMap<>();
	private final Map<Long, String> watchVideo = new HashMap<>();
	private final Map<Long, Long> dislikeVideo = new HashMap<>();

	@MockBean(VideosProducer.class)
	VideosProducer testProducer() {
		return (key, value) -> {
			postVideo.put(key, value);
			likeVideo.put(key, value);
			watchVideo.put(key, value);
			dislikeVideo.put(key, value);
		};
	}

	@BeforeEach
	public void clean() {
		repo.deleteAll();
		postVideo.clear();
		likeVideo.clear();
		watchVideo.clear();
		dislikeVideo.clear();
	}

	final String title = "Python in 30 seconds";
	final String[] tags = { "fun", "educational" };
	final String username = "test_user";

	@Test
	public void noVideos() {
		Iterable<Video> iterVideos = client.list();
		assertFalse(iterVideos.iterator().hasNext(), "Service should not list any videos initially");
	}

	@Test
	public void postBook() {
		VideoDTO video = new VideoDTO();
		video.setTitle(title);
		video.setTags("fun,educational");
		video.setUsername(username);
		HttpResponse<Void> response = client.post(video);
		assertEquals(HttpStatus.CREATED, response.getStatus(), "Update should be successful");

		Video createdVideo = client.getVideo(1);
		assertEquals(title, createdVideo.getTitle(), "Insert test message");

	}

	@Test
	public void likeVideo() {
		// Create the video
		VideoDTO video = new VideoDTO();
		video.setTitle(title);
		video.setTags("fun,educational");
		video.setUsername(username);
		HttpResponse<Void> response = client.post(video);
		assertEquals(HttpStatus.CREATED, response.getStatus(), "Update should be successful");

		// when a video is posted, the number of likes should be 0
		Video createdVideo = client.getVideo(1);
		assertEquals(0, createdVideo.getLikes());

		// like the video
		client.likeVideo(1, username);
		Video likedVideo = client.getVideo(1);
		assertEquals(1, likedVideo.getLikes().size());
	}
}
