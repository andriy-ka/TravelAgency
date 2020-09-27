package andriy.kachur.dao.implementations;

import andriy.kachur.dao.HotelDao;
import andriy.kachur.model.Hotel;
import org.apache.lucene.search.Query;
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
        try
        {
            Session session = sessionFactory.getCurrentSession();

            FullTextSession fullTextSession = Search.getFullTextSession(session);

            QueryBuilder qb = fullTextSession.getSearchFactory()
                    .buildQueryBuilder().forEntity(Hotel.class).get();
            Query query = qb
                    .keyword().onField("country")
                    .matching(country)
                    .createQuery();
            List<Hotel> hotels =
                    fullTextSession.createFullTextQuery(query, Hotel.class).list();

            return hotels;
        }
        catch(Exception e)
        {
            throw e;
        }
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
