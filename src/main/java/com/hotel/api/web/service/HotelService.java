package com.hotel.api.web.service;

import com.hotel.api.web.model.Room;
import com.hotel.api.web.model.User;
import com.hotel.api.web.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public User getUser(String email, String password) {
        return hotelRepository.findUser(email, password);
    }

    public void insertUser(User user) {
        hotelRepository.addUser(user);
    }

    public void insertRoom(Room room) {
        hotelRepository.addRoom(room);
    }

    public void updateRoom(Room room) {
        hotelRepository.updateRoom(room);
    }

    public List<Room> getAvailableRooms(Date startDate, Date endDate) {
        return hotelRepository.findAvailableRooms(startDate, endDate);
    }
}
