package york.eng2.subscription.repositories;

import java.util.Optional;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.subscription.domain.Video;

@Repository
public interface VideosRepository extends CrudRepository<Video, Long> {

	@Join(value = "hashtags", type = Join.Type.LEFT_FETCH)
	@Join(value = "user", type = Join.Type.FETCH)
	@Override
	Optional<Video> findById(@NonNull Long id);

	@Join(value = "hashtags", type = Join.Type.LEFT_FETCH)
	@Join(value = "user", type = Join.Type.FETCH)
	@Override
	Iterable<Video> findAll();

}
