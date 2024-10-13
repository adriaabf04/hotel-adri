package com.example.hoteladri.dto;

import java.sql.Date;

import com.example.hoteladri.model.PaymentStatus;

public class PaymentDTO {
    private Date date;
    private BookingDTO booking;
    private PaymentStatus status;

    public PaymentDTO() {
    }

    public PaymentDTO(Date date, BookingDTO booking, PaymentStatus status) {
        this.date = date;
        this.booking = booking;
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BookingDTO getBooking() {
        return booking;
    }

    public void setBooking(BookingDTO booking) {
        this.booking = booking;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
