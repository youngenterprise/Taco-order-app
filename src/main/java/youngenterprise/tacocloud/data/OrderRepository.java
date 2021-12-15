package youngenterprise.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import youngenterprise.tacocloud.Order;
import youngenterprise.tacocloud.User;

import java.awt.print.Pageable;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order>findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
