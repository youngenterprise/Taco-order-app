package youngenterprise.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import youngenterprise.tacocloud.Order;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
