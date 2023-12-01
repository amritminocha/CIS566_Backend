package com.hotel.api.web.repository;

import com.hotel.api.web.model.Room;
import com.hotel.api.web.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class HotelRepository {
    private final JdbcTemplate jdbcTemplate;

    public HotelRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM user", (rs, rowNum) ->
                new User(rs.getString("email"), rs.getString("password"), rs.getString("name"), rs.getString("type")));
    }

    public User findUser(String email, String password) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM user WHERE email=? AND password=?", new Object[]{email, password}, (rs, rowNum) ->
                    new User(rs.getString("email"), rs.getString("password"), rs.getString("name"), rs.getString("type")));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public void addUser(User user) {
        String sql = "INSERT INTO user (email, password, name, type) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.getName(), user.getType());
    }

    public void addRoom(Room room) {
        String sql = "INSERT INTO room (room_type, room_name, detail, amenities, price) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, room.getRoomType(), room.getRoomName(), room.getDetail(), room.getAmenities(), room.getPrice());
    }

    public void updateRoom(Room room) {
        String sql = "UPDATE room SET room_type=?, room_name=?, detail=?, amenities=?, price=? WHERE room_id=?";
        jdbcTemplate.update(sql, room.getRoomType(), room.getRoomName(), room.getDetail(), room.getAmenities(), room.getPrice(), room.getRoomId());
    }

    public List<Room> findAvailableRooms(Date startDate, Date endDate) {
        String sql = "SELECT *\n" +
                "FROM hotel.room\n" +
                "WHERE room_id NOT IN(\n" +
                "    SELECT bookings.room_id\n" +
                "    FROM bookings\n" +
                "    WHERE ? < bookings.start_date\n" +
                "    AND ? >= bookings.end_date\n" +
                "    AND bookings.status = \"BOOKED\"\n" +
                ");";
        return jdbcTemplate.query(sql, new Object[]{startDate, endDate}, (rs, rowNum) -> {
            Room room = new Room();
            room.setRoomId(rs.getInt("room_id"));
            room.setRoomType(rs.getString("room_type"));
            room.setRoomName(rs.getString("room_name"));
            room.setDetail(rs.getString("detail"));
            room.setAmenities(rs.getString("amenities"));
            room.setPrice(rs.getDouble("price"));
            return room;
        });
    }
}