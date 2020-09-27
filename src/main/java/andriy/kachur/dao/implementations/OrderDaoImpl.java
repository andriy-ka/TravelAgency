package andriy.kachur.dao.implementations;

import andriy.kachur.dao.OrderDao;
import andriy.kachur.model.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class OrderDaoImpl implements OrderDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }
}
