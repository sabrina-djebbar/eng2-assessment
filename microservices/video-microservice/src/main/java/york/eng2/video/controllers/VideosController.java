package york.eng2.video.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;
import york.eng2.video.domain.User;
import york.eng2.video.domain.Video;
import york.eng2.video.dto.VideoDTO;
import york.eng2.video.events.VideosProducer;
import york.eng2.video.repositories.UsersRepository;
import york.eng2.video.repositories.VideosRepository;

@Controller("/videos")
public class VideosController {

	@Inject
	VideosRepository repo;

	@Inject
	UsersRepository userRepo;

	@Inject
	VideosProducer producer;

	private User getUser(String username) {
		Optional<User> user = userRepo.findByUsername(username);
		if (user.isEmpty()) {
			User newUser = new User();
			newUser.setUsername(username);
			userRepo.save(newUser);
			return newUser;
		}
		return user.get();
	}

	@Get("/")
	public Iterable<Video> list() {
		return repo.findAll();
	}

	@Get("/{id}")
	public Video getVideo(long id) {
		return repo.findById(id).orElse(null);
	}

	@Post("/")
	public HttpResponse<Void> post(@Body VideoDTO videoDetails) {
		Video video = new Video();
		video.setTitle(videoDetails.getTitle());
		String tags = videoDetails.getTags();
		video.setTags(tags.split(","));
		User user = getUser(videoDetails.getUsername());
		video.setUser(user);
		video.setLikes(0);
		video.setDislikes(0);
		video.setViews(0);

		repo.save(video);
		producer.postVideo(video.getId(), video);
		return HttpResponse.created(URI.create("/videos/" + video.getId()));
	}

	@Transactional
	@Put("/{id}/like")
	public HttpResponse<Void> likeVideo(long id) {
		Optional<Video> video = repo.findById(id);
		if (video.isEmpty()) {
			return HttpResponse.notFound();
		}

		Video v = video.get();
		v.setLikes();
		repo.update(v);
		producer.likeVideo(id, v);
		return HttpResponse.ok();
	}

	@Transactional
	@Put("/{id}/dislike")
	public HttpResponse<Void> dislikeVideo(long id) {
		Optional<Video> video = repo.findById(id);
		if (video.isEmpty()) {
			return HttpResponse.notFound();
		}

		Video v = video.get();
		v.setDislikes();
		repo.update(v);
		producer.dislikeVideo(id, v);
		return HttpResponse.ok();
	}

	@Transactional
	@Put("/{videoId}/watch/{username}")
	public HttpResponse<Void> watchVideo(long videoId, String username) {
		Optional<Video> video = repo.findById(videoId);
		if (video.isEmpty()) {
			return HttpResponse.notFound();
		}

		Video v = video.get();
		v.setViews();
		repo.update(v);

		Long userId = getUser(username).getId();
		producer.watchVideo(videoId, userId);
		return HttpResponse.ok();
	}

}
