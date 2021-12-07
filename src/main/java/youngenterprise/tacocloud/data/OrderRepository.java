package youngenterprise.tacocloud.data;

import youngenterprise.tacocloud.Order;

public interface OrderRepository {
    Order save(Order order);
}
