package york.eng2.video.repositories;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.video.domain.Video;

@Repository
public interface VideosRepository extends CrudRepository<Video, Long> {
	Iterable<Video> findAllByUserId(Long userId);

	@Query("SELECT * FROM video v WHERE tag = any(regexp_split_to_array(v.tags, '\\s*,\\s*')) ")
	Iterable<Video> findAllByTag(String tag);
}
