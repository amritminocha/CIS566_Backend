package com.hotel.api.web.controller;

import com.hotel.api.web.model.ApiResponse;
import com.hotel.api.web.model.Booking;
import com.hotel.api.web.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<ApiResponse<Object>> bookRoom(@RequestBody Booking booking) {
        ApiResponse<Object> response = new ApiResponse<>();
        bookingService.bookRoom(booking);
        response.setSuccess(true);
        response.setMessage("Booking added");
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings(@RequestParam(required = false) String email) {
        List<Booking> bookings;
        if (Objects.nonNull(email)) {
            bookings = bookingService.getBookingsByEmail(email);
        } else {
            bookings = bookingService.getAllBookings();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(booking);
    }

    @PutMapping("/{bookingId}/status")
    public ResponseEntity<ApiResponse<Object>> updateBookingStatus(@PathVariable String bookingId,
                                                                   @RequestParam String status) {
        ApiResponse<Object> response = new ApiResponse<>();
        bookingService.updateBookingStatus(bookingId, status);
        response.setSuccess(true);
        response.setMessage("Booking status updated");
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<ApiResponse<Object>> deleteBooking(@PathVariable String bookingId) {
        ApiResponse<Object> response = new ApiResponse<>();
        bookingService.deleteBooking(bookingId);
        response.setSuccess(true);
        response.setMessage("Booking removed");
        return ResponseEntity.ok().body(response);
    }

}