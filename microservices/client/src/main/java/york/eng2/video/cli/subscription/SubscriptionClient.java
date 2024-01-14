package york.eng2.video.cli.subscription;

import java.util.List;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import york.eng2.video.cli.domain.User;
import york.eng2.video.cli.domain.Video;

@Client("${subscription.url:`http://localhost:8082/users`}")
public interface SubscriptionClient {

	@Get("/")
	public Iterable<User> list();

	@Get("/videos")
	public Iterable<Video> listVideos();

	@Get("/{username}/tag/{tag}")
	public List<Video> getNextVideosToWatch(String username, String tag);

	@Put("/{username}/subscribe/{tag}")
	public HttpResponse<Void> subscribeToHashtag(String username, String tag);

	@Put("/{username}/unsubscribe/{tag}")
	public HttpResponse<Void> unsubscribeToHashtag(String username, String tag);
}
