package york.eng2.video.repositories;

import java.util.Optional;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.video.domain.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
