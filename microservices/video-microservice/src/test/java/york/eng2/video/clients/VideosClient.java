package york.eng2.video.clients;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import york.eng2.video.domain.Video;
import york.eng2.video.dto.VideoDTO;

@Client("/videos")
public interface VideosClient {

	@Get("/")
	public Iterable<Video> list();

	@Get("/{id}")
	public Video getVideo(long id);

	@Get("/user/{username}")
	public Iterable<Video> listByUsername(String username);

	@Get("/tag/{tag}")
	public Iterable<Video> listByTag(String tag);

	@Post("/")
	public HttpResponse<Void> post(@Body VideoDTO videoDetails);

	@Put("/{id}/like/{username}")
	public HttpResponse<Void> likeVideo(long id, String username);

	@Put("/{id}/dislike/{username}")
	public HttpResponse<Void> dislikeVideo(long id, String username);

	@Put("/{videoId}/watch/{username}")
	public HttpResponse<Void> watchVideo(long videoId, String username);
}
