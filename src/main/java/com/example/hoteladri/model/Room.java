package com.example.hoteladri.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberRoom;
    private String type;
    private double price;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    
    public Room() {
    }

    public Room(int numberRoom, String type, double price, RoomStatus status) {
        this.numberRoom = numberRoom;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
