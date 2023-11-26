package york.eng2.trending.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.trending.domain.Hashtag;

@Repository
public interface HashtagsRepository extends CrudRepository<Hashtag, Long> {

}
