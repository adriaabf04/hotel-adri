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

        public List<Booking> obtainBookingByClient(Long clienteId) {
            return reservaRepository.findByClienteId(clienteId);
        }

        public Booking obtainBookingById(Long id) {
            return reservaRepository.findById(id).orElse(null);
        }
        
        
        public Booking keepBooking(Booking reserva, Long clienteId) {
            Room habitacion = habitacionRepository.findById(reserva.getRoom().getId()).orElse(null);
            if(habitacion.getStatus() == RoomStatus.BUSY) {
                return null;
            } else {
                Client cliente = clienteRepository.findById(clienteId).orElse(null);
                habitacion.setStatus(RoomStatus.BUSY);
                reserva.setClient(cliente);
                reserva.setRoom(habitacion);
                reserva.setStatus(BookingStatus.PENDING);
            }
            
            return reservaRepository.save(reserva);
        }

        public Booking confirmBooking(Booking reserva, Long clienteId) {
            Client cliente = clienteRepository.findById(clienteId).orElse(null);
            reserva.setClient(cliente);
            reserva.confirmarReserva();
            Payment pago = new Payment();
            pago.setBooking(reserva);
            pago.setStatus(PaymentStatus.TRANSFERENCE);
            pago.setDate(new java.sql.Date(System.currentTimeMillis()));
            pagoRepository.save(pago);
            return reservaRepository.save(reserva);
        }

        public void cancelBooking(Booking reserva, Long clienteId) {
            if(reserva.getStatus().equals(BookingStatus.PENDING)) {
                Client cliente = clienteRepository.findById(clienteId).orElse(null);
                reserva.setClient(cliente);
                reserva.cancelarReserva();
                reservaRepository.save(reserva);
            } else {
                throw new RuntimeException("No se puede cancelar una reserva confirmada");
            }
        }
}
