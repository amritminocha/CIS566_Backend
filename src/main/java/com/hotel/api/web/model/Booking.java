package com.hotel.api.web.model;

public class Booking {


    private long bookingId;
    private String roomId;
    private String name;
    private String email;
    private String roomType;
    private long startDate;
    private long endDate;
    private int price;
    private String status;

    public Booking() {
    }

    public Booking(String roomId, String name, String email, String roomType, long startDate, long endDate, int price,
                   String status) {
        super();
        this.roomId = roomId;
        this.name = name;
        this.email = email;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.status = status;
    }


    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public String getRoomId() {
        return roomId;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public long getStartDate() {
        return startDate;
    }
    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }
    public long getEndDate() {
        return endDate;
    }
    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



}