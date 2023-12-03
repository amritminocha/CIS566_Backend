package com.hotel.api.web.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.api.web.model.AmenityDecorator;
import com.hotel.api.web.model.Room;
import com.hotel.api.web.model.User;

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
    @Transactional
    public void addRoom(Room room) {
        String sql = "INSERT INTO room (room_type, room_name, detail, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, room.getRoomType(), room.getRoomName(), room.getDetail(), room.getPrice());
        Long roomId =  jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        AmenityDecorator decoratorChain = buildDecoratorChain(room.getAmenities());
        while (decoratorChain != null) {
        	if(decoratorChain.getNextDecorator()==null)
        		return;
     	   decoratorChain.addAmenities(roomId, jdbcTemplate);
     	   decoratorChain = decoratorChain.getNextDecorator();
        }
    }
    
    private AmenityDecorator buildDecoratorChain(List<String> amenities) {
        AmenityDecorator chain = new SimpleAmenityDecorator(); 

        for (String amenity : amenities) {
            chain = createDecorator(amenity, chain);
        }

        return chain;
    }

    private AmenityDecorator createDecorator(String amenityName, AmenityDecorator nextDecorator) {
        switch (amenityName) {
            case "wifi":
                return new WifiAmenity(nextDecorator);
            case "fridge":
                return new FridgeAmenity(nextDecorator);
            case "tv":
                return new TVAmenity(nextDecorator);
            default:
                return new FridgeAmenity(nextDecorator); 
        }
    }
    
    public void updateRoom(Room room) {
        String sql = "UPDATE room SET room_type=?, room_name=?, detail=?,  price=? WHERE room_id=?";
        jdbcTemplate.update(sql, room.getRoomType(), room.getRoomName(), room.getDetail(), room.getPrice(), room.getRoomId());
    }

    @SuppressWarnings("deprecation")
	public List<Room> findAvailableRooms(Date startDate, Date endDate) {
        String sql = "SELECT room.*,amenity.amenity_name \n" +
                "FROM hotel.room\n" +
        		"LEFT JOIN amenity ON room.room_id = amenity.room_id " +
                "WHERE room.room_id NOT IN(\n" +
                "    SELECT bookings.room_id\n" +
                "    FROM bookings\n" +
                "    WHERE ? < bookings.start_date\n" +
                "    AND ? >= bookings.end_date\n" +
                "    AND bookings.status = \"BOOKED\"\n" +
                ");";
//        return jdbcTemplate.query(sql, new Object[]{startDate, endDate}, (rs, rowNum) -> {
//            Room room = new Room();
//            room.setRoomId(rs.getInt("room_id"));
//            room.setRoomType(rs.getString("room_type"));
//            room.setRoomName(rs.getString("room_name"));
//            room.setDetail(rs.getString("detail"));
//            room.setAmenities(rs.getString("amenities"));
//            room.setPrice(rs.getDouble("price"));
//            return room;
//        });
//        
         return jdbcTemplate.query(sql, new Object[]{startDate, endDate}, (rs )-> {
            Map<Integer, Room> roomMap = new HashMap<>();

            while (rs.next()) {
                int roomId = rs.getInt("room_id");
                Room room = new Room();
              room.setRoomId(rs.getInt("room_id"));
              room.setRoomType(rs.getString("room_type"));
              room.setRoomName(rs.getString("room_name"));
              room.setDetail(rs.getString("detail"));
              room.setPrice(rs.getDouble("price"));
              
              Room roomObject = roomMap.get(roomId);
              List <String> amenities;
                if (roomMap.containsKey(roomId)) {
                    amenities = roomObject.getAmenities()==null?new ArrayList<String>():roomObject.getAmenities();
                }else {
                     amenities = new ArrayList<String>();
                }
                String amenityName = rs.getString("amenity_name");
                if (amenityName != null) {
                	amenities.add(amenityName);
                	room.setAmenities(amenities);
                }
                roomMap.put(roomId, room);
            }
            return new ArrayList<>(roomMap.values());
        });
        
    }
}