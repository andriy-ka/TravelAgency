package andriy.kachur.dao;

import andriy.kachur.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface HotelDao {
    public List<Hotel> listHotels();
    public void addHotel(Hotel hotel);
}
