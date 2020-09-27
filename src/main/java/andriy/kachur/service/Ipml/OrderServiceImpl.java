package andriy.kachur.service.Ipml;

import andriy.kachur.dao.HotelDao;
import andriy.kachur.dao.OrderDao;
import andriy.kachur.model.Order;
import andriy.kachur.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void addOrder(Order order) {
        this.orderDao.addOrder(order);
    }
}
