package com.example.hoteladri.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.EnumType;
import java.sql.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    private Room room;
    @ManyToOne
    private Client client;
    private Date startDate;
    private Date fechaFin;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public Booking(Room room, Client client, Date startDate, Date fechaFin, BookingStatus status) {
        this.room = room;
        this.client = client;
        this.startDate = startDate;
        this.fechaFin = fechaFin;
        this.status = status;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Client getClient() {
        return client;
    }

    public Date getstartDate() {
        return startDate;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setstartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void confirmarReserva() {
        this.status = BookingStatus.CONFIRMED;
    }

    public void cancelarReserva() {
        this.status = BookingStatus.CANCELLED;
    }
}