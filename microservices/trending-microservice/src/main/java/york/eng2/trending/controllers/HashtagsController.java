package york.eng2.trending.controllers;

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
import york.eng2.trending.domain.Hashtag;
import york.eng2.trending.dto.HashtagDTO;
import york.eng2.trending.repositories.HashtagsRepository;

@Controller("/hashtags")
public class HashtagsController {

	@Inject
	HashtagsRepository repo;

	@Get("/")
	public Iterable<Hashtag> list() {
		return repo.findAll();
	}

	@Post("/")
	public HttpResponse<Void> add(@Body HashtagDTO hashtagDetails) {
		Hashtag hashtag = new Hashtag();
		hashtag.setName(hashtagDetails.getName());

		repo.save(hashtag);
		return HttpResponse.created(URI.create("/hashtags/" + hashtag.getId()));
	}

	@Get("/{id}")
	public Hashtag getHashtag(long id) {
		return repo.findById(id).orElse(null);
	}

	@Post("/")
	public Hashtag createHashtag(@Body HashtagDTO hashtagDetails) {
		Hashtag hashtag = new Hashtag();
		hashtag.setName(hashtagDetails.getName());

		repo.save(hashtag);
		return hashtag;
	};

	@Transactional
	@Put("/{id}")
	public HttpResponse<Void> updateHashtag(long id, @Body HashtagDTO hashtagDetails) {
		Optional<Hashtag> hashtag = repo.findById(id);
		if (hashtag.isEmpty()) {
			return HttpResponse.notFound();
		}

		Hashtag t = hashtag.get();
		if (hashtagDetails.getName() != null) {
			t.setName(hashtagDetails.getName());
		}
		repo.save(t);
		return HttpResponse.ok();
	}

	@Get("/tag/{name}")
	public Hashtag getByName(String name) {
		return repo.findByName(name).orElse(null);
	}

}