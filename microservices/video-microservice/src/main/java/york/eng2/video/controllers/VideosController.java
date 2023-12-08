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
import york.eng2.video.domain.Hashtag;
import york.eng2.video.domain.User;
import york.eng2.video.domain.Video;
import york.eng2.video.dto.HashtagDTO;
import york.eng2.video.dto.VideoDTO;
import york.eng2.video.events.VideosProducer;
import york.eng2.video.repositories.HashtagsRepository;
import york.eng2.video.repositories.UsersRepository;
import york.eng2.video.repositories.VideosRepository;

@Controller("/videos")
public class VideosController {

	@Inject
	VideosRepository repo;

	@Inject
	UsersRepository userRepo;

	@Inject
	HashtagsRepository hashtagRepo;

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

	private Hashtag getHashtag(String hashtag) {
		Optional<Hashtag> tag = hashtagRepo.findByName(hashtag);
		if (tag.isEmpty()) {
			Hashtag newTag = new Hashtag();
			newTag.setName(hashtag);
			hashtagRepo.save(newTag);
			return newTag;
		}
		return tag.get();
	}

	@Get("/")
	public Iterable<Video> list() {
		return repo.findAll();
	}

	@Get("/{id}")
	public Video getVideo(long id) {
		return repo.findById(id).orElse(null);
	}

	@Get("/user/{username}")
	public Iterable<Video> listByUsername(String username) {
		return repo.findAllByUsername(username);
	}

	@Get("/tag/{tag}")
	public Iterable<Video> listByTag(String tag) {
		return repo.findAllByTag(tag);
	}

	@Transactional
	@Post("/")
	public HttpResponse<Void> post(@Body VideoDTO videoDetails) {
		Video video = new Video();
		video.setTitle(videoDetails.getTitle());

		String[] hashtags = videoDetails.getTags().split(",");
		for (String hashtag : hashtags) {
			Hashtag tag = getHashtag(hashtag);
			video.setHashtags(tag);
		}

		User user = getUser(videoDetails.getUsername());
		video.setUser(user);

		repo.save(video);
		producer.postVideo(video.getId(), video);
		return HttpResponse.created(URI.create("/videos/" + video.getId()));
	}

	@Transactional
	@Put("/{id}/like/{username}")
	public HttpResponse<Void> likeVideo(long id, String username) {
		Optional<Video> video = repo.findById(id);
		if (video.isEmpty()) {
			return HttpResponse.notFound();
		}
		Video v = video.get();
		User u = getUser(username);

		v.setLikes(u);
		repo.update(v);

		u.setLikedVideos(v);
		userRepo.save(u);

		producer.likeVideo(id, v);
		return HttpResponse.ok();
	}

	@Transactional
	@Put("/{id}/dislike/{username}")
	public HttpResponse<Void> dislikeVideo(long id, String username) {
		Optional<Video> video = repo.findById(id);
		if (video.isEmpty()) {
			return HttpResponse.notFound();
		}

		Video v = video.get();
		User u = getUser(username);

		v.setDislikes(u);
		repo.update(v);

		u.setDislikedVideos(v);
		userRepo.save(u);

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
		User u = getUser(username);

		v.setViewers(u);
		repo.update(v);

		u.setViewedVideos(v);
		userRepo.update(u);

		Long userId = u.getId();

		producer.watchVideo(videoId, userId);
		return HttpResponse.ok();
	}

}
