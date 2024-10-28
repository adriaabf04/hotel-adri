package com.example.hoteladri.service;

import com.example.hoteladri.model.Client;
import com.example.hoteladri.model.RoomStatus;
import com.example.hoteladri.model.PaymentStatus;
import com.example.hoteladri.model.BookingStatus;
import com.example.hoteladri.model.Room;
import com.example.hoteladri.model.Payment;
import com.example.hoteladri.dto.BookingDTO;
import com.example.hoteladri.dto.PaymentDTO;
import com.example.hoteladri.model.Booking;
import com.example.hoteladri.repository.IClientRepository;
import com.example.hoteladri.repository.IRoomRepository;
import com.example.hoteladri.repository.IPaymentRepository;
import com.example.hoteladri.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookingService {
    @Autowired
    private IBookingRepository bookingRepository;

    @Autowired
    private IClientRepository clientRepository;

    @Autowired 
    private IRoomRepository roomRepository;

    @Autowired
    private IPaymentRepository paymentRepository;
    
    public List<BookingDTO> obtainAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingDTO> bookingDTOs = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDTO bookingDTO = new BookingDTO(booking);
            bookingDTOs.add(bookingDTO);
        }
        return bookingDTOs;
    }

    public List<BookingDTO> obtainBookingByClient(Client client) {
        List<Booking> bookings = bookingRepository.findByClient(client);
        List<BookingDTO> bookingDTOs = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDTO bookingDTO = new BookingDTO(booking);
            bookingDTOs.add(bookingDTO);
        }
        return bookingDTOs;
    }

    public BookingDTO obtainBookingById(Long id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if(booking != null) {
            return new BookingDTO(booking);
        } else {
            throw new RuntimeException("Reserva no encontrada");
        }
    }
        
        
    public BookingDTO keepBooking(Booking booking, int roomId) {
        Room room = roomRepository.findByNumberRoom(roomId);
        if(room.getStatus().equals(RoomStatus.DISPONIBLE)) {
            booking.setRoom(room);
            booking.setStatus(BookingStatus.PENDING);
            Client cliente = clientRepository.findById(booking.getClient().getId()).orElse(null);
            booking.setClient(cliente);
            bookingRepository.save(booking);
            return new BookingDTO(booking);
        } else {
            throw new RuntimeException("La habitación no está disponible");
        }
    }

    public PaymentDTO confirmBooking(Booking booking, int roomId) {
        Room room = roomRepository.findByNumberRoom(roomId);
        Booking bookingToConfirm = bookingRepository.findById(booking.getId()).orElse(null);
        if(room.getStatus().equals(RoomStatus.DISPONIBLE)) {
            bookingToConfirm.setRoom(room);
            bookingToConfirm.setStatus(BookingStatus.CONFIRMED);
            Client cliente = clientRepository.findById(bookingToConfirm.getClient().getId()).orElse(null);
            bookingToConfirm.setClient(cliente);
            room.setStatus(RoomStatus.BUSY);
            roomRepository.save(room);
            bookingRepository.save(bookingToConfirm);
            Payment pago = new Payment();
            pago.setBooking(bookingToConfirm);
            pago.setDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
            pago.setStatus(PaymentStatus.TRANSFERENCE);
            Payment paymentSaved = paymentRepository.save(pago);
            return new PaymentDTO(paymentSaved.getDate(), new BookingDTO(paymentSaved.getBooking()), paymentSaved.getStatus());
        } else {
            throw new RuntimeException("La habitación no está disponible");
        }
    }

    public void cancelBooking(Booking booking, int roomId) {
        Room room = roomRepository.findByNumberRoom(roomId);
        Booking bookingToCancel = bookingRepository.findById(booking.getId()).orElse(null);
        if(room.getStatus().equals(RoomStatus.DISPONIBLE)) {
            bookingToCancel.setRoom(room);
            bookingToCancel.setStatus(BookingStatus.CANCELLED);
            Client cliente = clientRepository.findById(booking.getClient().getId()).orElse(null);
            bookingToCancel.setClient(cliente);
            bookingRepository.save(bookingToCancel);
            room.setStatus(RoomStatus.DISPONIBLE);
            roomRepository.save(room);
        } else {
            throw new RuntimeException("La habitación no está disponible");
        }
    }
}
