package andriy.kachur.service;

import andriy.kachur.model.Hotel;

import java.util.List;

public interface HotelService {
    public List<Hotel> listHotels();
    public void addHotel(Hotel hotel);


}
