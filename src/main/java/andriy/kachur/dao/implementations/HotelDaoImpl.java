package andriy.kachur.dao.implementations;

import andriy.kachur.dao.HotelDao;
import andriy.kachur.model.Hotel;
import org.apache.lucene.search.Query;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
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
    @Transactional
    public List<Hotel> listHotels() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Hotel> hotelsList = session.createQuery("from Hotel").list();
        return hotelsList;
    }

    @Override
    @Transactional
    public void addHotel(Hotel hotel) {
        sessionFactory.getCurrentSession().saveOrUpdate(hotel);
    }

    @Override
    @Transactional
    public List<Hotel> findHotelByCountry(String country){
        List<Hotel> hotelsList = null;
        Session session = sessionFactory.getCurrentSession();
        Filter filter = session.enableFilter("countryFilter");
        filter.setParameter("country", country);
        hotelsList = session.createQuery("from Hotel").list();
        return hotelsList;
    }
//        Session session = this.sessionFactory.getCurrentSession();
//        List<Hotel> hotelsList = session.createQuery("from Hotel").list();
//        List<Hotel> hotelByCountry = hotelsList;
//        for(Hotel hotel : hotelsList){
//            if(hotel.getCountry().equals(country)){
//                hotelByCountry.add(hotel);
//            }
//        }
//        return hotelsList;
//    }


    @Override
    @Transactional
    public Hotel findHotelById(Integer hotelId) {
        return sessionFactory.getCurrentSession().get(Hotel.class, hotelId);
    }

    @Override
    @Transactional
    public void deleteHotel(Hotel hotel) {
        sessionFactory.getCurrentSession().delete(hotel);
    }

}
