package com.example.hoteladri.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToOne
    private Booking booking;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    public Payment(Date date, Booking booking, PaymentStatus status) {
        this.date = date;
        this.booking = booking;
        this.status = status;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Booking getBooking() {
        return booking;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
