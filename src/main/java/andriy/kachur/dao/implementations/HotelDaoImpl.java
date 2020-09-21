package andriy.kachur.dao.implementations;

import andriy.kachur.dao.HotelDao;
import andriy.kachur.model.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {

    private static final Logger logger = LoggerFactory.getLogger(HotelDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Hotel> listHotels() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Hotel> hotelsList = session.createQuery("from Hotel").list();
        for (Hotel p : hotelsList) {
            logger.info("Hotel List::" + p);
        }
        return hotelsList;
    }

    @Override
    public void addHotel(Hotel hotel) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(hotel);
        logger.info("Person saved successfully, Person Details=" + hotel);
    }
}
