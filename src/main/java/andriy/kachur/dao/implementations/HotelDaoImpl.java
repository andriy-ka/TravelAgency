package andriy.kachur.dao.implementations;

import andriy.kachur.dao.HotelDao;
import andriy.kachur.model.Hotel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {


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

        return hotelsList;
    }

    @Override
    @Transactional
    public void addHotel(Hotel hotel) {
        //Session session = this.sessionFactory.getCurrentSession();
        sessionFactory.getCurrentSession().save(hotel);
    }

    @Override
    public List<Hotel> findHotelByCountry(String country) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Hotel> hotelByCountry =
                session.createQuery("from Hotel where country=:country")
                .setParameter("country", country)
                .list();
        return hotelByCountry;
    }

}
