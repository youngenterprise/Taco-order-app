package youngenterprise.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import youngenterprise.tacocloud.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findbyUsername(String username);
}
