package york.eng2.video.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.video.domain.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

}
