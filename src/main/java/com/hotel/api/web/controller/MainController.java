package com.hotel.api.web.controller;

import com.hotel.api.web.model.*;
import com.hotel.api.web.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Object>> login(@RequestBody LoginRequest loginRequest) {
        User user = hotelService.getUser(loginRequest.email, loginRequest.password);
        ApiResponse<Object> response = new ApiResponse<>();

        if (Objects.isNull(user)) {
            response.setSuccess(false);
            response.setMessage("User Not Found");
        } else {
            response.setSuccess(true);
            response.setMessage("Login successful");
            response.setData(user);
        }

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Object>> signUp(@RequestBody User user) {
        ApiResponse<Object> response = new ApiResponse<>();
        hotelService.insertUser(user);
        response.setSuccess(true);
        response.setMessage("User added");
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/addRoom")
    public ResponseEntity<ApiResponse<Object>> addRoom(@RequestBody Room room) {
        ApiResponse<Object> response = new ApiResponse<>();
        hotelService.insertRoom(room);
        response.setSuccess(true);
        response.setMessage("Room added");
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/updateRoom")
    public ResponseEntity<ApiResponse<Object>> updateRoom(@RequestBody Room room) {
        ApiResponse<Object> response = new ApiResponse<>();
        hotelService.updateRoom(room);
        response.setSuccess(true);
        response.setMessage("Room updated");
        return ResponseEntity.ok().body(response);
    }





}
