package york.eng2.video.repositories;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.video.domain.Video;

@Repository
public interface VideosRepository extends CrudRepository<Video, Long> {

	Iterable<Video> findByUserId(Long userId);

	@Query("from Video v where :tag in v.tags")
	Iterable<Video> findByTag(String tag);

}
