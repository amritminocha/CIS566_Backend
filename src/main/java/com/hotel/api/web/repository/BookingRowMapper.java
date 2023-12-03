package com.hotel.api.web.repository;

import com.hotel.api.web.model.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingRowMapper implements RowMapper<Booking> {

    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        Booking booking = new Booking();
        booking.setBookingId(rs.getInt("booking_id"));
        booking.setRoomId(rs.getInt("room_id"));
        booking.setName(rs.getString("name"));
        booking.setEmail(rs.getString("email"));
        booking.setStartDate(rs.getDate("start_date").toLocalDate());
        booking.setEndDate(rs.getDate("end_date").toLocalDate());
        booking.setStatus(rs.getString("status"));
        return booking;
    }


}