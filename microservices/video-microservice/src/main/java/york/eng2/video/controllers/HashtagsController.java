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
import york.eng2.video.dto.HashtagDTO;
import york.eng2.video.repositories.HashtagsRepository;

@Controller("/hashtags")
public class HashtagsController {
	@Inject
	HashtagsRepository repo;

	@Get("/")
	public Iterable<Hashtag> list() {
		return repo.findAll();
	}

	@Post("/")
	public HttpResponse<Void> add(@Body HashtagDTO HashtagDetails) {
		Hashtag hashtag = new Hashtag();
		hashtag.setName(HashtagDetails.getName());
		System.out.println(hashtag);
		repo.save(hashtag);
		return HttpResponse.created(URI.create("/hashtags/" + hashtag.getId()));
	}

	@Get("/{name}")
	public Hashtag getHashtag(String name) {
		return repo.findByName(name).orElse(null);
	}

	@Transactional
	@Put("/{id}")
	public HttpResponse<Void> updateHashtag(long id, @Body HashtagDTO hashtagDetails) {
		Optional<Hashtag> hashtag = repo.findById(id);
		if (hashtag.isEmpty()) {
			return HttpResponse.notFound();
		}

		Hashtag h = hashtag.get();
		if (hashtagDetails.getName() != null) {
			h.setName(hashtagDetails.getName());
		}
		repo.save(h);
		return HttpResponse.ok();
	}
	/*
	 * @Transactional
	 * 
	 * @Delete("/{id}") public HttpResponse<Void> deleteHashtag(long id) {
	 * Optional<Hashtag> Hashtag = repo.findById(id); if (Hashtag.isEmpty()) {
	 * return HttpResponse.notFound(); }
	 * 
	 * repo.delete(Hashtag.get()); return HttpResponse.ok(); }
	 */

}
