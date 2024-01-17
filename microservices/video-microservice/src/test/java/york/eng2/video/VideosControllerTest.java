package york.eng2.video;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import york.eng2.video.clients.VideosClient;
import york.eng2.video.domain.Video;
import york.eng2.video.dto.VideoDTO;
import york.eng2.video.events.MockVideosProducer;
import york.eng2.video.events.VideosProducer;
import york.eng2.video.repositories.VideosRepository;

@MicronautTest(transactional = false)
public class VideosControllerTest {
	@Inject
	VideosClient client;

	@Inject
	VideosRepository repo;

	@MockBean(VideosProducer.class)
	public VideosProducer testProducer() {
		return new MockVideosProducer() {
			
		};
	};

	@BeforeEach
	public void clean() {
		repo.deleteAll();
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

	@Test
	public void dislikeVideo() {
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

		//dislike the video
		client.dislikeVideo(1, username);
		Video dislikedVideo = client.getVideo(1);
		assertEquals(0, dislikedVideo.getLikes().size());
	}

	@Test
	public void watchVideo() {
		// Create the video
		VideoDTO video = new VideoDTO();
		video.setTitle(title);
		video.setTags("fun,educational");
		video.setUsername(username);
		HttpResponse<Void> response = client.post(video);
		assertEquals(HttpStatus.CREATED, response.getStatus(), "Update should be successful");

		// when a video is posted, the number of views should be 0
		Video createdVideo = client.getVideo(1);
		assertEquals(0, createdVideo.getViewers());

		// watch the video
		client.watchVideo(1, username);
		Video watchedVideo = client.getVideo(1);
		assertEquals(1, watchedVideo.getViewers().size());
	}
}
