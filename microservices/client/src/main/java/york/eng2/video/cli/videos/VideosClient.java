package york.eng2.video.cli.videos;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import york.eng2.video.cli.domain.Video;
import york.eng2.video.cli.dto.VideoDTO;

@Client("${videos.url:`http://localhost:8080/videos`}")
public interface VideosClient {

	@Get("/")
	Iterable<Video> list();

	@Post("/")
	HttpResponse<Void> post(@Body VideoDTO videoDetails);

	@Get("/{id}")
	public Video getVideo(long id);

	@Put("/{id}/like/{username}")
	public HttpResponse<Void> likeVideo(long id, String username);

	@Put("/{id}/dislike/{username}")
	public HttpResponse<Void> dislikeVideo(long id, String username);

	@Put("/{videoId}/watch/{username}")
	public HttpResponse<Void> watchVideo(long videoId, String username);
}
