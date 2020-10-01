package andriy.kachur.service.Ipml;

import andriy.kachur.dao.OrderDao;
import andriy.kachur.model.Order;
import andriy.kachur.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        this.orderDao.addOrder(order);
    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }
}
