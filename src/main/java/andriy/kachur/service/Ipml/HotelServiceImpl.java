package andriy.kachur.service.Ipml;

import andriy.kachur.dao.HotelDao;
import andriy.kachur.model.Hotel;
import andriy.kachur.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {


    private final HotelDao hotelDao;

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    @Transactional
    public List<Hotel> listHotels() {
        return this.hotelDao.listHotels();
    }

    @Override
    @Transactional
    public void addHotel(Hotel hotel) {
        this.hotelDao.addHotel(hotel);
    }
}
