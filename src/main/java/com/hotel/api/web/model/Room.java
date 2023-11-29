package com.hotel.api.web.model;

public class Room {
    public String roomType;
    public String roomName;
    public String detail;
    public String amenities;
    public double price;

    //    public int roomId;
//
//    public int getRoomId() {
//        return roomId;
//    }
//
//    public void setRoomId(int roomId) {
//        this.roomId = roomId;
//    }



    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room(String roomType, String roomName, String detail, String amenities, double price) {
        this.roomType = roomType;
        this.roomName = roomName;
        this.detail = detail;
        this.amenities = amenities;
        this.price = price;
    }
}
