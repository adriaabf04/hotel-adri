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
        
        
    public Booking keepBooking(Booking reserva, Long clienteId) {
        Room habitacion = habitacionRepository.findById(reserva.getRoom().getId()).orElse(null);
        if(habitacion.getStatus() == RoomStatus.BUSY || habitacion.getStatus() == RoomStatus.MAINTENANCE) {
            return null;
        } else {
            Client cliente = clienteRepository.findById(clienteId).orElse(null);
            reserva.setClient(cliente);
            reserva.setRoom(habitacion);
            reserva.setStatus(BookingStatus.PENDING);
        }
        
        return reservaRepository.save(reserva);
    }

    public Payment confirmBooking(Booking reservaa, Long clienteId) {
        Room habitacion = habitacionRepository.findById(reservaa.getRoom().getId()).orElse(null);
        habitacion.setStatus(RoomStatus.BUSY);
        habitacionRepository.save(habitacion);
        Booking booking = reservaRepository.findById(reservaa.getId()).orElse(null);
        booking.confirmarReserva();
        reservaRepository.save(booking);
        Payment pago = new Payment();
        pago.setBooking(booking);
        pago.setStatus(PaymentStatus.TRANSFERENCE);
        pago.setDate(new java.sql.Date(System.currentTimeMillis()));
        return pagoRepository.save(pago);
    }

    public void cancelBooking(Booking reserva, Long clienteId) {
        if(reserva.getStatus().equals(BookingStatus.PENDING)) {
            Client cliente = clienteRepository.findById(clienteId).orElse(null);
            reserva.setClient(cliente);
            reserva.cancelarReserva();
            reservaRepository.save(reserva);
            Room habitacion = habitacionRepository.findById(reserva.getRoom().getId()).orElse(null);
            habitacion.setStatus(RoomStatus.DISPONIBLE);
            habitacionRepository.save(habitacion);
        } else {
            throw new RuntimeException("No se puede cancelar una reserva confirmada");
        }
    }
}
