package york.eng2.video.repositories;

import java.util.Optional;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.video.domain.Video;

@Repository
public interface VideosRepository extends CrudRepository<Video, Long> {
	
	@Join(value = "user", type = Join.Type.FETCH)
	@Override
	Optional<Video> findById(@NonNull Long id);
	
	@Join(value = "user", type = Join.Type.FETCH)
	@Override
	Iterable<Video> findAll();
	
	@Join(value = "user", type = Join.Type.FETCH)
	@Query("from Video v where v.user.username= :username")
	Iterable<Video> findAllByUsername(String username);

	// THIS DOES NOT WORK	
	@Join(value = "user", type = Join.Type.FETCH)
	@Query("from Video v where :tag = any v.hashtags.name ")
	Iterable<Video> findAllByTag(String tag);

}
