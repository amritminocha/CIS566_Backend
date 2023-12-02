package com.hotel.api.web.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hotel.api.web.model.AmenityDecorator;

public class TVAmenity extends AmenityDecorator {

	public TVAmenity(AmenityDecorator nextDecorator) {
		super(nextDecorator);
	}

	@Override
	public void addAmenities(Long roomId, JdbcTemplate jdbcTemplate) {
		String insertAmenitySql = "INSERT INTO Amenity (room_id, amenity_name) VALUES (?, ?)";
		jdbcTemplate.update(insertAmenitySql, roomId, "tv");
	}
}
