package andriy.kachur.service;

import andriy.kachur.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> listHotels();
    void addHotel(Hotel hotel);
    List<Hotel> findHotelByCountry(String country);


}
