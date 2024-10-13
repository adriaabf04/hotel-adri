package com.example.hoteladri.service;

import com.example.hoteladri.model.Client;
import com.example.hoteladri.model.RoomStatus;
import com.example.hoteladri.model.PaymentStatus;
import com.example.hoteladri.model.BookingStatus;
import com.example.hoteladri.model.Room;
import com.example.hoteladri.model.Payment;
import com.example.hoteladri.model.Booking;
import com.example.hoteladri.repository.IClientRepository;
import com.example.hoteladri.repository.IRoomRepository;
import com.example.hoteladri.repository.IPaymentRepository;
import com.example.hoteladri.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService {
    @Autowired
    private IBookingRepository reservaRepository;

    @Autowired
    private IClientRepository clienteRepository;

    @Autowired 
    private IRoomRepository habitacionRepository;

    @Autowired
    private IPaymentRepository pagoRepository;
    
    public List<Booking> obtainAllBookings() {
        return reservaRepository.findAll();
    }

    public List<Booking> obtainBookingByClient(Client client) {
        return reservaRepository.findByClient(client);
    }

    public Booking obtainBookingById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }
        
        
    public Booking keepBooking(Booking reserva, int habitacionId) {
        Room room = habitacionRepository.findByNumberRoom(habitacionId);
        if(room.getStatus().equals(RoomStatus.DISPONIBLE)) {
            reserva.setRoom(room);
            reserva.setStatus(BookingStatus.PENDING);
            Client cliente = clienteRepository.findById(reserva.getClient().getId()).orElse(null);
            reserva.setClient(cliente);
            return reservaRepository.save(reserva);
        } else {
            throw new RuntimeException("La habitación no está disponible");
        }
    }

    public Payment confirmBooking(Booking reserva, int habitacionId) {
        Room room = habitacionRepository.findByNumberRoom(habitacionId);
        if(room.getStatus().equals(RoomStatus.DISPONIBLE)) {
            reserva.setRoom(room);
            reserva.setStatus(BookingStatus.CONFIRMED);
            Client cliente = clienteRepository.findById(reserva.getClient().getId()).orElse(null);
            reserva.setClient(cliente);
            reservaRepository.save(reserva);
            room.setStatus(RoomStatus.DISPONIBLE);
            habitacionRepository.save(room);
            Payment pago = new Payment();
            pago.setBooking(reserva);
            pago.setDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
            pago.setStatus(PaymentStatus.TRANSFERENCE);
            return pagoRepository.save(pago);
        } else {
            throw new RuntimeException("La habitación no está disponible");
        }
    }

    public void cancelBooking(Booking reserva, int habitacionId) {
        Room room = habitacionRepository.findByNumberRoom(habitacionId);
        if(room.getStatus().equals(RoomStatus.DISPONIBLE)) {
            reserva.setRoom(room);
            reserva.setStatus(BookingStatus.CANCELLED);
            Client cliente = clienteRepository.findById(reserva.getClient().getId()).orElse(null);
            reserva.setClient(cliente);
            reservaRepository.save(reserva);
            room.setStatus(RoomStatus.DISPONIBLE);
            habitacionRepository.save(room);
        } else {
            throw new RuntimeException("La habitación no está disponible");
        }
    }
}
