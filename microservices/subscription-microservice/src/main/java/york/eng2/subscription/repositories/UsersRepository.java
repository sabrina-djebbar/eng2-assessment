package york.eng2.subscription.repositories;

import java.util.Optional;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import york.eng2.subscription.domain.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

	@Join(value = "subscribedTo", type = Join.Type.LEFT_FETCH)
	@Override
	Optional<User> findById(@NonNull Long id);

	@Join(value = "subscribedTo", type = Join.Type.LEFT_FETCH)
	@Override
	Iterable<User> findAll();

	Optional<User> findByUsername(String username);
}
