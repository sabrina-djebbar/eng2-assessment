package york.eng2.subscription.repositories;

import java.util.Optional;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.subscription.domain.Hashtag;

@Repository
public interface HashtagsRepository extends CrudRepository<Hashtag, Long> {

	Optional<Hashtag> findByName(String name);

}