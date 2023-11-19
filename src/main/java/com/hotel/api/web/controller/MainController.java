package com.hotel.api.web.controller;

import com.hotel.api.web.model.User;
import com.hotel.api.web.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final HotelService hotelService;

    public MainController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return hotelService.getUsers();
    }


}
