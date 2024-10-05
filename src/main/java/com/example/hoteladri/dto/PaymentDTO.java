package com.example.hoteladri.dto;

import java.sql.Date;

public class PaymentDTO {
    private Date date;
    private BookingDTO booking;
    private PaymentDTO status;

    public PaymentDTO() {
    }

    public PaymentDTO(Date date, BookingDTO booking, PaymentDTO status) {
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

    public PaymentDTO getStatus() {
        return status;
    }

    public void setStatus(PaymentDTO status) {
        this.status = status;
    }
}
