package com.hotel.api.web.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.hotel.api.web.model.Amenity;
import com.hotel.api.web.model.Room;

public class RoomWithAmenitiesRowMapper implements RowMapper<Map<Integer, Room>>{

//	  @Override
//	    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
//	        Room room = new Room(null, null, null, null, rowNum);
//	        room.setRoomId(rs.getInt("room_id"));
//	        room.setRoomType(rs.getString("room_type"));
//	        room.setRoomName(rs.getString("room_name"));
//	        room.setDetail(rs.getString("detail"));
//	        room.setPrice(rs.getDouble("price"));
//	        room.setAmenities(rs.getString("amenity_name")); 
//
//	        return room;
//	    }
//	  
	
	@Override
	public Map<Integer, Room> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<Integer, Room> roomMap = new HashMap<>();

		do {
			Integer roomId = rs.getInt("room_id");

			if (!roomMap.containsKey(roomId)) {
				Room room = new Room();
				room.setRoomId(roomId);
				room.setRoomType(rs.getString("room_type"));
				room.setRoomName(rs.getString("room_name"));
				room.setDetail(rs.getString("detail"));
				room.setPrice(rs.getDouble("price"));
				room.setAmenities(new ArrayList<>());

				roomMap.put(roomId, room);
			}
			roomMap.get(roomId).getAmenities().add(rs.getString("amenity_name"));
		} while (rs.next());

		return roomMap;
	}
	  
	  
}
