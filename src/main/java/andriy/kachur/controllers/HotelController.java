package andriy.kachur.controllers;

import andriy.kachur.model.Hotel;
import andriy.kachur.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

//    @GetMapping("/homepage")
//    public String homepage(Model model){
//        List<Hotel> hotels = this.hotelService.listHotels();
//        model.addAttribute("hotels", hotels);
//        return "homepage";
//    }

    @GetMapping(value = "/addHotel")
    public String addHotel(Model model){
        Hotel hotel = new Hotel();
        model.addAttribute("hotel", hotel);
        return "addHotel";
    }

//    @GetMapping(name = "/filter")
//    public String findHotelByCountry(@RequestParam String country, Model model){
//        List<Hotel> hotels = this.hotelService.findHotelByCountry(country);
//        model.addAttribute("hotels", hotels);
//        return "filter";
//    }


    @GetMapping(value = "/filter")
    public ModelAndView searchPage()
    {
//        List<Hotel> allFound = hotelService.findHotelByCountry(country);
//        List<Hotel> hotelModels = new ArrayList();
//        for (Hotel h : allFound)
//        {
//            Hotel hotel = new Hotel();
//            hotel.setId(h.getId());
//            hotel.setName(h.getName());
//            hotel.setCountry(h.getCountry());
//            hotel.setAvailableRooms(h.getAvailableRooms());
//            hotel.setRooms(h.getRooms());
//
//            hotelModels.add(hotel);
//        }
//        ModelAndView mav = new ModelAndView("filter");
//        mav.addObject("foundHotels", hotelModels);
//        return mav;
        ModelAndView mav = new ModelAndView("filter");
        return mav;
    }

    @PostMapping(value = "/filter")
    public ModelAndView search(@RequestParam("country") String country) throws Exception
    {
        List<Hotel> allFound = hotelService.findHotelByCountry(country);
        List<Hotel> hotelModels = new ArrayList();

        for (Hotel h : allFound)
        {
            Hotel hotel = new Hotel();
            hotel.setId(h.getId());
            hotel.setName(h.getName());
            hotel.setCountry(h.getCountry());
            hotel.setAvailableRooms(h.getAvailableRooms());
            hotel.setRooms(h.getRooms());

            hotelModels.add(hotel);
        }

        ModelAndView mav = new ModelAndView("filter");
        mav.addObject("foundHotels", hotelModels);
        return mav;
    }



    @PostMapping(value= "/addHotel")
    public String addHotel(@ModelAttribute("hotel") Hotel hotel){
        this.hotelService.addHotel(hotel);
        return "redirect:/hotel/management";
    }

//    @PostMapping(name = "/filter")
//    public String findHotelByCountry(@RequestParam String country, Model model){
//        List<Hotel> hotels = this.hotelService.findHotelByCountry(country);
//        model.addAttribute("hotels", hotels);
//        return "redirect:/hotel/management";
//    }

    @GetMapping(value = "/showUpdateForm")
    public String showUpdateForm(@RequestParam("hotelId") Integer hotelId, Model model){
        Hotel hotel = findById(hotelId);
        model.addAttribute("hotel", hotel);
        return "addHotel";
    }

    @GetMapping(value = "/deleteRecord")
    public String deleteHotel(@RequestParam("hotelId") Integer hotelId){
        Hotel hotel = findById(hotelId);
        hotelService.deleteHotel(hotel);
        return "redirect:/hotel/management";
    }

    private Hotel findById(Integer hotelId){
        Hotel hotel = hotelService.findHotelById(hotelId);
        return hotel;
    }

}
