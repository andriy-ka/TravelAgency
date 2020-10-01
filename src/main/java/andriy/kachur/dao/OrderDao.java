package andriy.kachur.dao;

import andriy.kachur.model.Order;

import java.util.List;

public interface OrderDao {
    void addOrder(Order order);
    List<Order> getAllOrders();
}
