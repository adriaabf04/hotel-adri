package com.example.hoteladri.dto;

import java.sql.Date;

import com.example.hoteladri.model.Booking;
import com.example.hoteladri.model.BookingStatus;

public class BookingDTO {
    private RoomDTO roomDTO;
    private ClientDTO clientDTO;
    private Date startDate;
    private Date endDate;
    private BookingStatus status;

    public BookingDTO() {
    }

    public BookingDTO(RoomDTO roomDTO, ClientDTO clientDTO, Date startDate, Date endDate) {
        this.roomDTO = roomDTO;
        this.clientDTO = clientDTO;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = BookingStatus.PENDING;
    }

    public BookingDTO(Booking booking) {
        this.roomDTO = new RoomDTO(booking.getRoom().getNumberRoom(), booking.getRoom().getType(), booking.getRoom().getPrice(), booking.getRoom().getStatus());
        this.clientDTO = new ClientDTO(booking.getClient().getId(), booking.getClient().getName(), booking.getClient().getSurname(), booking.getClient().getEmail());
        this.startDate = booking.getstartDate();
        this.endDate = booking.getFechaFin();
        this.status = booking.getStatus();
    }

    public RoomDTO getRoomDTO() {
        return roomDTO;
    }

    public void setRoomDTO(RoomDTO roomDTO) {
        this.roomDTO = roomDTO;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
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

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void confirmBooking() {
        this.status = BookingStatus.CONFIRMED;
    }

    public void cancelBooking() {
        this.status = BookingStatus.CANCELLED;
    }
}
