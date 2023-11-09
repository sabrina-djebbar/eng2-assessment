package york.eng2.video.repositories;

import java.util.Optional;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.video.domain.Video;
import york.eng2.video.dto.VideoDTO;

@Repository
public interface VideosRepository extends CrudRepository<Video, Long> {

	Optional<VideoDTO> findOne(long id);

	// TODO: Find by tag and user id
}
