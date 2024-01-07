package york.eng2.subscription.controllers;

import java.util.Optional;

import javax.transaction.Transactional;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;
import york.eng2.subscription.domain.Hashtag;
import york.eng2.subscription.domain.User;
import york.eng2.subscription.domain.Video;
import york.eng2.subscription.events.SubscriptionProducer;
import york.eng2.subscription.repositories.HashtagsRepository;
import york.eng2.subscription.repositories.UsersRepository;
import york.eng2.subscription.repositories.VideosRepository;

@Controller("/users")
public class UsersController {
	@Inject
	UsersRepository repo;

	@Inject
	HashtagsRepository hashtagRepo;

	@Inject
	VideosRepository videoRepo;

	@Inject
	SubscriptionProducer producer;

	private User getUser(String username) {
		Optional<User> user = repo.findByUsername(username);
		if (user.isEmpty()) {
			User newUser = new User();
			newUser.setUsername(username);
			repo.save(newUser);
			return newUser;
		}
		return user.get();
	}

	@Get("/")
	public Iterable<User> list() {
		return repo.findAll();
	}

	@Get("/{username}/tag/{tag}")
	public Iterable<Video> getNextVideosToWatch() {
		return videoRepo.findAll();
	}

	@Transactional
	@Put("/{username}/subscribe/{tag}")
	public HttpResponse<Void> subscribeToHashtag(String username, String tag) {
		Optional<Hashtag> hashtag = hashtagRepo.findByName(tag);
		if (hashtag.isEmpty()) {
			return HttpResponse.notFound();
		}
		Hashtag h = hashtag.get();

		User user = getUser(username);
		user.subscribedToHashtag(h);

		repo.save(user);
		producer.subscribeToHashtag(user.getId(), h);

		return HttpResponse.ok();
	}

	@Transactional
	@Put("/{username}/unsubscribe/{tag}")
	public HttpResponse<Void> unsubscribeToHashtag(String username, String tag) {
		Optional<Hashtag> hashtag = hashtagRepo.findByName(tag);
		if (hashtag.isEmpty()) {
			return HttpResponse.notFound();
		}
		Hashtag h = hashtag.get();

		User user = getUser(username);
		user.unsubscribedToHashtag(h);

		repo.save(user);
		producer.unsubscribeToHashtag(user.getId(), h);

		return HttpResponse.ok();
	}

}
