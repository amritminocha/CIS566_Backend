package com.hotel.api.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Booking {

    private int bookingId;
    private int roomId;
    private String email;
    private String name;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date endDate;
    private String status;

    public Booking() {
    }

    public Booking(int bookingId, int roomId, String name, String email, Date startDate, Date endDate,
                   String status) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.email = email;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
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
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



}