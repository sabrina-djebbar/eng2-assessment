package york.eng2.video.controllers;

import java.util.List;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import york.eng2.video.domain.Video;
import york.eng2.video.repositories.VideosRepository;

@Controller("/videos")
public class VideosController {

	@Inject
	VideosRepository repo;

	// change this so we log in on load "/"
	@Get("/")
	public List<Video> list() {
		return repo.findAll();
	}
}
