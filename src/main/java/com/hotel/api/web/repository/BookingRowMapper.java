package com.hotel.api.web.repository;

import com.hotel.api.web.model.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingRowMapper implements RowMapper<Booking> {

    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        Booking booking = new Booking();
        booking.setBookingId(rs.getLong("booking_id"));
        booking.setRoomId(rs.getString("room_id"));
        booking.setName(rs.getString("name"));
        booking.setEmail(rs.getString("email"));
        booking.setRoomType(rs.getString("room_type"));
        booking.setStartDate(rs.getLong("start_date"));
        booking.setEndDate(rs.getLong("end_date"));
        booking.setPrice(rs.getInt("price"));
        booking.setStatus(rs.getString("status"));
        return booking;
    }


}