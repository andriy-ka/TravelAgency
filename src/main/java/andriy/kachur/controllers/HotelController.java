package andriy.kachur.controllers;

import andriy.kachur.model.Hotel;
import andriy.kachur.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/list")
    public String listHotels(Model model){
        List<Hotel> hotels = this.hotelService.listHotels();
        model.addAttribute("hotels", hotels);
        return "list";
    }

//    @GetMapping(value = "/addHotel")
//    public String addHotel(){
//        return "addHotel";
//    }
//
//
//    @PostMapping(value= "/addHotel")
//    public String addHotel(@ModelAttribute("hotel") Hotel hotel){
//        if(hotel.getId() == 0){
//            //new hotel, add it
//            this.hotelService.addHotel(hotel);
//        }
//        return "list";
//    }




}
