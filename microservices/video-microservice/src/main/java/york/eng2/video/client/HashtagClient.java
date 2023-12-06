package york.eng2.video.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import york.eng2.video.domain.Hashtag;
import york.eng2.video.dto.HashtagDTO;

@Client("http://trending:8080")
public interface HashtagClient {

	@Get("/")
	Iterable<Hashtag> list();

	@Post("/")
	HttpResponse<Void> add(@Body HashtagDTO hashtagDetails);

	@Get("/{id}")
	Hashtag getHashtag(long id);

	@Get("/{name}")
	Hashtag getByName(String name);

	@Post("/")
	Hashtag createHashtag(@Body HashtagDTO hashtagDetails);
}
