package com.hotel.api.web.service;

import com.hotel.api.web.model.User;
import com.hotel.api.web.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<User> getUsers() {
        return hotelRepository.findAll();
    }
}
