package andriy.kachur.dao;

import andriy.kachur.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface HotelDao {
    List<Hotel> listHotels();
    void addHotel(Hotel hotel);
    List<Hotel> findHotelByCountry(String country);
    Hotel findHotelById(Integer hotelId);
    void deleteHotel(Hotel hotel);
}
