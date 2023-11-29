package com.hotel.api.web.service;

import com.hotel.api.web.model.Booking;
import com.hotel.api.web.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {


    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAllBookings();
    }

    public Booking getBookingById(String bookingId) {
        return bookingRepository.findBookingById(bookingId);
    }

    public Booking bookRoom(Booking booking) {
        // Implement additional code for validating and processing bookings
        bookingRepository.saveBooking(booking);
        return booking;
    }

    public void updateBookingStatus(String bookingId, String status) {
        bookingRepository.updateBookingStatus(bookingId, status);
    }

    public void deleteBooking(String bookingId) {
        bookingRepository.deleteBooking(bookingId);
    }

}