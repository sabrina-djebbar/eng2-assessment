package york.eng2.video.controllers;

import java.net.URI;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import york.eng2.video.domain.Video;
import york.eng2.video.dto.VideoDTO;
import york.eng2.video.repositories.VideosRepository;

@Controller("/videos")
public class VideosController {

	@Inject
	VideosRepository repo;

	// change this so we log in on load "/"
	@Get("/")
	public Iterable<Video> list() {
		return repo.findAll();
	}

	@Post("/")
	public HttpResponse<Void> post(@Body VideoDTO videoDetails) {
		Video video = new Video();
		video.setTitle(videoDetails.getTitle());
		video.setTags(videoDetails.getTags());
		video.setUserId(videoDetails.getUserId());
		repo.save(video);
		return HttpResponse.created(URI.create("/videos/" + video.getId()));
	}
}
