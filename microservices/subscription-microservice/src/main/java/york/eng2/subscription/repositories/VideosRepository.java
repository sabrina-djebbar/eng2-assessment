package york.eng2.subscription.repositories;

import java.util.Optional;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.subscription.domain.Video;

@Repository
public interface VideosRepository extends CrudRepository<Video, Long> {

	@Join(value = "views", type = Join.Type.LEFT_FETCH)
	@Join(value = "user", type = Join.Type.FETCH)
	@Override
	Optional<Video> findById(@NonNull Long id);

	@Join(value = "views", type = Join.Type.LEFT_FETCH)
	@Join(value = "user", type = Join.Type.FETCH)
	@Override
	Iterable<Video> findAll();

	@Join(value = "user", type = Join.Type.FETCH)
	@Join(value = "views", type = Join.Type.LEFT_FETCH)
	@Query("select v from Video v inner join Hashtag h where h.name=:tag")
	Iterable<Video> findAllByHashtag(String tag);

}
