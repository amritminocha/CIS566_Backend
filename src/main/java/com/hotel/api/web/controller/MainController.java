package com.hotel.api.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping
    public String getServerRunning() {
        return "Server running";
    }

}
