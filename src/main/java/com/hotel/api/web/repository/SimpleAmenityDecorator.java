package com.hotel.api.web.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hotel.api.web.model.Amenity;
import com.hotel.api.web.model.AmenityDecorator;

public class SimpleAmenityDecorator extends AmenityDecorator {
	  //private AmenityDecorator next;
	 public SimpleAmenityDecorator() {
	        super(null);  // No next decorator
	    }

//	@Override
//	public void addAmenities(Long roomId, List<Amenity> amenities) {
//		// TODO Auto-generated method stub
//
//	}
	
	@Override
	public void addAmenities(Long roomId,  JdbcTemplate jdbcTemplate) {
		
		
	}

}
