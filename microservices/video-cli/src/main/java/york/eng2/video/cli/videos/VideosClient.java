package york.eng2.video.cli.videos;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import york.eng2.video.cli.domain.Video;
import york.eng2.video.cli.dto.VideoDTO;

@Client("${video.url:`http://localhost:8080/videos`}")
public interface VideosClient {

	@Get("/")
	Iterable<Video> list();

	@Post("/")
	HttpResponse<Void> add(@Body VideoDTO videoDetails);
}
