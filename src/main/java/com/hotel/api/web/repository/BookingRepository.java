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

    public Booking findBookingById(String bookingId) {
        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookingId}, new BookingRowMapper());
    }

    public void saveBooking(Booking booking) {
        String sql = "INSERT INTO bookings ( room_id, name, email, room_type, start_date, end_date, price, status) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, booking.getRoomId(), booking.getName(), booking.getEmail(),
                booking.getRoomType(), booking.getStartDate(), booking.getEndDate(), booking.getPrice(), booking.getStatus());
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