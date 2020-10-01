package andriy.kachur.controllers;

import andriy.kachur.dao.OrderDao;
import andriy.kachur.model.Hotel;
import andriy.kachur.model.Order;
import andriy.kachur.service.HotelService;
import andriy.kachur.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private HotelService hotelService;
    private OrderService orderService;

    public HotelController() {
    }

    @Autowired
    public HotelController(HotelService hotelService, OrderService orderService) {
        this.hotelService = hotelService;
        this.orderService = orderService;
    }

    @GetMapping("/management")
    public String listHotels(Model model){
        List<Hotel> hotels = this.hotelService.listHotels();
        model.addAttribute("hotels", hotels);
        List<Order> orders = this.orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "management";
    }

    @GetMapping(value = "/filter")
    public String searchPage(@RequestParam String country, Model model) {
        List<Hotel> allFound = hotelService.findHotelByCountry(country);
        if(allFound == null) {
            List<Hotel> hotels = hotelService.listHotels();
            model.addAttribute("foundHotels", hotels);
            return "filter";
        }
        model.addAttribute("foundHotels", allFound);
        return "filter";
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
