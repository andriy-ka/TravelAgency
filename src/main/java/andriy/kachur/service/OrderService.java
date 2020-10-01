package andriy.kachur.service;

import andriy.kachur.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    List<Order> getAllOrders();
}
