package com.hotel.api.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AmenityDecorator {
	
	protected Room room;
    protected AmenityDecorator nextDecorator;

	  public AmenityDecorator getNextDecorator() {
		return nextDecorator;
	}

	public void setNextDecorator(AmenityDecorator nextDecorator) {
		this.nextDecorator = nextDecorator;
	}

	public AmenityDecorator(AmenityDecorator nextDecorator) {
	        this.nextDecorator = nextDecorator;
	    }

	//public abstract void addAmenities(List<String> amenityNames);
	
    public abstract void addAmenities(Long roomId,JdbcTemplate jdbcTemplate);
//    abstract AmenityDecorator getNext();
//    abstract void setNext(AmenityDecorator next);
}
