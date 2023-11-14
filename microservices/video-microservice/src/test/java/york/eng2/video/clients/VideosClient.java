package york.eng2.video.clients;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import york.eng2.video.domain.Video;
import york.eng2.video.dto.VideoDTO;

@Client("${video.url:`http://localhost:8080/videos`}")
public interface VideosClient {

	@Get("/")
	Iterable<Video> list();

	@Post("/")
	HttpResponse<Void> post(@Body VideoDTO videoDetails);

	@Get("/{id}")
	public Video getVideo(long id);

	@Put("/{id}/like")
	public HttpResponse<Void> likeVideo(long id);

	@Put("/{id}/dislike")
	public HttpResponse<Void> dislikeVideo(long id);

	@Put("/{videoId}/watch/{userId}")
	public HttpResponse<Void> watchVideo(long videoId, String userId);
}
