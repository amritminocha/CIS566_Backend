package com.hotel.api.web.model;

public class Amenity {
	 private Long id;
	    private String name;
	    
	    public Amenity(String name) {
	        this.name = name;
	    }
	    
		public Amenity() {
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	    
	    
}
