package york.eng2.video.cli.trending;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import york.eng2.video.cli.domain.Hashtag;
import york.eng2.video.cli.dto.HashtagDTO;

@Client("${hashtags.url:`http://localhost:8081/hashtags`}")
public interface TrendingClient {

	@Get("/")
	public Iterable<Hashtag> list();

	@Post("/")
	public HttpResponse<Void> add(@Body HashtagDTO hashtagDetails);

	@Get("/{id}")
	public Hashtag getHashtag(long id);

	@Put("/{id}")
	public HttpResponse<Void> updateHashtag(long id, @Body HashtagDTO hashtagDetails);

}
