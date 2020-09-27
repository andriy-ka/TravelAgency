package andriy.kachur.controllers;


import andriy.kachur.model.Hotel;
import andriy.kachur.model.Order;
import andriy.kachur.service.HotelService;
import andriy.kachur.service.OrderService;
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
public class OrderController {

    private OrderService orderService;
    private HotelService hotelService;

    public OrderController() {
    }

    @Autowired
    public OrderController(OrderService orderService, HotelService hotelService) {
        this.orderService = orderService;
        this.hotelService = hotelService;
    }

    @GetMapping("/homepage")
    public String homepage(Model model){
        List<Hotel> hotels = this.hotelService.listHotels();
        model.addAttribute("hotels", hotels);
        return "homepage";
    }

    @GetMapping(value = "/addOrder")
    public String addOrder(Model model){
        Order order = new Order();
        model.addAttribute("order", order);
        return "addOrder";
    }

    @PostMapping(value= "/addOrder")
    public String addOrder(@ModelAttribute("order") Order order){
        this.orderService.addOrder(order);
        return "redirect:/hotel/homepage";
    }


}
