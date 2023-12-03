package com.hotel.api.web.repository;

import com.hotel.api.web.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Booking> findAllBookings() {
        String sql = "SELECT * FROM bookings";
        return jdbcTemplate.query(sql, new BookingRowMapper());
    }

    public List<Booking> findBookingsByEmail(String email) {
        String sql = "SELECT * FROM bookings WHERE email = ?";
        return jdbcTemplate.query(sql, new Object[]{email}, new BookingRowMapper());
    }

    public Booking findBookingById(String bookingId) {
        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookingId}, new BookingRowMapper());
    }

    public void saveBooking(Booking booking) {
        String sql = "INSERT INTO bookings ( room_id, email, name, start_date, end_date, status) " +
                "VALUES ( ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, booking.getRoomId(), booking.getEmail(), booking.getName(),
                booking.getStartDate(), booking.getEndDate(), booking.getStatus());
    }

    public void updateBookingStatus(String bookingId, String status) {
        String sql = "UPDATE bookings SET status = ? WHERE booking_id = ?";
        jdbcTemplate.update(sql, status, bookingId);
    }

    public void deleteBooking(String bookingId) {
        String sql = "DELETE FROM bookings WHERE booking_id = ?";
        jdbcTemplate.update(sql, bookingId);
    }

}