package andriy.kachur.controllers;


import andriy.kachur.model.Hotel;
import andriy.kachur.model.Order;
import andriy.kachur.service.HotelService;
import andriy.kachur.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotel")
public class OrderController {

    private OrderService orderService;
    private HotelService hotelService;
    static int hotelId;

    public OrderController() {
    }

    @Autowired
    public OrderController(OrderService orderService, HotelService hotelService) {
        this.orderService = orderService;
        this.hotelService = hotelService;
    }

    @GetMapping("/homepage")
    public String homepage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)auth.getPrincipal();
        List<Hotel> hotels = this.hotelService.listHotels();
        model.addAttribute("hotels", hotels);
        model.addAttribute("username", user.getUsername());
        return "homepage";
    }

    @GetMapping(value = "/addOrder")
    public String addOrder(Model model, @RequestParam("hotelId") Integer hotelId){
        Order order = new Order();
        this.hotelId = hotelId;
        String hotelname  = findById(hotelId).getName();
        model.addAttribute("order", order);
        model.addAttribute("hotelname", hotelname);
        return "addOrder";
    }

    @PostMapping(value= "/addOrder")
    public String addOrder(@ModelAttribute("order") Order order){
        this.orderService.addOrder(order);
        Hotel hotel = findById(hotelId);
        hotel.setAvailableRooms(hotel.getAvailableRooms()-order.getRoom());
        hotelService.addHotel(hotel);
        return "redirect:/hotel/homepage";
    }

    private Hotel findById(Integer hotelId){
        Hotel hotel = hotelService.findHotelById(hotelId);
        return hotel;
    }


}
