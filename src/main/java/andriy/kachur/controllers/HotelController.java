package andriy.kachur.controllers;

import andriy.kachur.model.Hotel;
import andriy.kachur.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private HotelService hotelService;

    public HotelController() {
    }

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/management")
    public String listHotels(Model model){
        List<Hotel> hotels = this.hotelService.listHotels();
        model.addAttribute("hotels", hotels);
        return "management";
    }

    @GetMapping(value = "/addHotel")
    public String addHotel(Model model){
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);
        return "addHotel";
    }

    @PostMapping(value= "/addHotel")
    public String addHotel(@ModelAttribute("hotel") Hotel hotel){
        this.hotelService.addHotel(hotel);
        return "redirect:/hotel/management";
    }
    @PostMapping(name = "")
    public List<Hotel> findHotelByCountry(String country){
        return null;
    }




}
