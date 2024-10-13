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
    private IBookingRepository reservaRepository;

    @Autowired
    private IClientRepository clienteRepository;

    @Autowired 
    private IRoomRepository habitacionRepository;

    @Autowired
    private IPaymentRepository pagoRepository;
    
    public List<BookingDTO> obtainAllBookings() {
        List<Booking> reservas = reservaRepository.findAll();
        List<BookingDTO> reservaDTOs = new ArrayList<>();
        for (Booking reserva : reservas) {
            BookingDTO reservaDTO = new BookingDTO(reserva);
            reservaDTOs.add(reservaDTO);
        }
        return reservaDTOs;
    }

    public List<BookingDTO> obtainBookingByClient(Client client) {
        List<Booking> reservas = reservaRepository.findByClient(client);
        List<BookingDTO> reservaDTOs = new ArrayList<>();
        for (Booking reserva : reservas) {
            BookingDTO reservaDTO = new BookingDTO(reserva);
            reservaDTOs.add(reservaDTO);
        }
        return reservaDTOs;
    }

    public BookingDTO obtainBookingById(Long id) {
        Booking reserva = reservaRepository.findById(id).orElse(null);
        if(reserva != null) {
            return new BookingDTO(reserva);
        } else {
            throw new RuntimeException("Reserva no encontrada");
        }
    }
        
        
    public BookingDTO keepBooking(Booking reserva, int habitacionId) {
        Room room = habitacionRepository.findByNumberRoom(habitacionId);
        if(room.getStatus().equals(RoomStatus.DISPONIBLE)) {
            reserva.setRoom(room);
            reserva.setStatus(BookingStatus.PENDING);
            Client cliente = clienteRepository.findById(reserva.getClient().getId()).orElse(null);
            reserva.setClient(cliente);
            reservaRepository.save(reserva);
            return new BookingDTO(reserva);
        } else {
            throw new RuntimeException("La habitación no está disponible");
        }
    }

    public PaymentDTO confirmBooking(Booking reserva, int habitacionId) {
        Room room = habitacionRepository.findByNumberRoom(habitacionId);
        if(room.getStatus().equals(RoomStatus.DISPONIBLE)) {
            reserva.setRoom(room);
            reserva.setStatus(BookingStatus.CONFIRMED);
            Client cliente = clienteRepository.findById(reserva.getClient().getId()).orElse(null);
            reserva.setClient(cliente);
            reservaRepository.save(reserva);
            room.setStatus(RoomStatus.BUSY);
            habitacionRepository.save(room);
            Payment pago = new Payment();
            pago.setBooking(reserva);
            pago.setDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
            pago.setStatus(PaymentStatus.TRANSFERENCE);
            Payment paymentSaved = pagoRepository.save(pago);
            return new PaymentDTO(paymentSaved.getDate(), new BookingDTO(paymentSaved.getBooking()), paymentSaved.getStatus());
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
