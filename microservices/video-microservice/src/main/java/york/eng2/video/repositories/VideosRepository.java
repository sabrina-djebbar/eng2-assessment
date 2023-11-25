package york.eng2.video.repositories;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.video.domain.Video;

@Repository
public interface VideosRepository extends CrudRepository<Video, Long> {

	@Query("SELECT * FROM videos v WHERE userId = v.userId")
	Iterable<Video> findAllByUserId(Long userId);

}
