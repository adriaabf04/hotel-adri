package com.example.hoteladri.dto;

import com.example.hoteladri.model.RoomStatus;

public class RoomDTO {
    private int numberRoom; 
    private String type;
    private double price;
    private RoomStatus status;

    public RoomDTO() {
    }

    public RoomDTO(int numberRoom, String type, double price, RoomStatus status) {
        this.numberRoom = numberRoom;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
