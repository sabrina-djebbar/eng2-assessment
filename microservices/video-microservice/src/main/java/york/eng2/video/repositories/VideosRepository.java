package york.eng2.video.repositories;

import java.util.Optional;

import javax.persistence.JoinTable;


import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.video.domain.Video;

@Repository
public interface VideosRepository extends CrudRepository<Video, Long> {

	@Join(value = "likes", type = Join.Type.LEFT_FETCH)
	@Join(value = "viewers", type = Join.Type.LEFT_FETCH)
	@Join(value = "dislikes", type = Join.Type.LEFT_FETCH)
	@Join(value = "user", type = Join.Type.FETCH)
	@Override
	Optional<Video> findById(@NonNull Long id);

	@Join(value = "likes", type = Join.Type.LEFT_FETCH)
	@Join(value = "dislikes", type = Join.Type.LEFT_FETCH)
	@Join(value = "viewers", type = Join.Type.LEFT_FETCH)
	@Join(value = "user", type = Join.Type.FETCH)
	@Override
	Iterable<Video> findAll();

	@Join(value = "likes", type = Join.Type.LEFT_FETCH)
	@Join(value = "dislikes", type = Join.Type.LEFT_FETCH)
	@Join(value = "viewers", type = Join.Type.LEFT_FETCH)
	@Join(value = "user", type = Join.Type.FETCH)
	@Query("from Video v where v.user.username= :username")
	Iterable<Video> findAllByUsername(String username);
}
