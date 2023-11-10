package york.eng2.video.repositories;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.video.domain.Video;
import york.eng2.video.dto.VideoDTO;

@Repository
public interface VideosRepository extends CrudRepository<Video, Long> {

	@Join(value = "viewers", type = Join.Type.LEFT_FETCH)
	@Override
	Optional<Video> findById(@NotNull Long id);

	Optional<VideoDTO> findOne(long id);

	// TODO: Find by tag and user id
}
