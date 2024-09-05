package com.example.hoteladri.service;

import com.example.hoteladri.model.Cliente;
import com.example.hoteladri.model.EstadoHabitacion;
import com.example.hoteladri.model.EstadoPago;
import com.example.hoteladri.model.EstadoReserva;
import com.example.hoteladri.model.Habitacion;
import com.example.hoteladri.model.Pago;
import com.example.hoteladri.model.Reserva;
import com.example.hoteladri.repository.ClienteRepository;
import com.example.hoteladri.repository.HabitacionRepository;
import com.example.hoteladri.repository.PagoRepository;
import com.example.hoteladri.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservaService {
        @Autowired
        private ReservaRepository reservaRepository;

        @Autowired
        private ClienteRepository clienteRepository;

        @Autowired 
        private HabitacionRepository habitacionRepository;

        @Autowired
        private PagoRepository pagoRepository;
    
        public List<Reserva> obtenerTodasLasReservas() {
            return reservaRepository.findAll();
        }

        public List<Reserva> obtenerReservasPorCliente(Long clienteId) {
            return reservaRepository.findByClienteId(clienteId);
        }

        public Reserva obtenerReservaPorId(Long id) {
            return reservaRepository.findById(id).orElse(null);
        }
        
        
        public Reserva guardarReserva(Reserva reserva, Long clienteId) {
            Habitacion habitacion = habitacionRepository.findById(reserva.getHabitacion().getId()).orElse(null);
            if(habitacion.getEstado() == EstadoHabitacion.OCUPADA) {
                return null;
            } else {
                Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
                habitacion.setEstado(EstadoHabitacion.OCUPADA);
                reserva.setCliente(cliente);
                reserva.setHabitacion(habitacion);
                reserva.setEstado(EstadoReserva.PENDIENTE);
            }
            
            return reservaRepository.save(reserva);
        }

        public Reserva confirmarReserva(Reserva reserva, Long clienteId) {
            Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
            reserva.setCliente(cliente);
            reserva.confirmarReserva();
            Pago pago = new Pago();
            pago.setReserva(reserva);
            pago.setEstado(EstadoPago.TRANSEFERENCIA);
            pago.setFecha(new java.sql.Date(System.currentTimeMillis()));
            pagoRepository.save(pago);
            return reservaRepository.save(reserva);
        }

        public void cancelarReserva(Reserva reserva, Long clienteId) {
            if(reserva.getEstado().equals(EstadoReserva.PENDIENTE)) {
                Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
                reserva.setCliente(cliente);
                reserva.cancelarReserva();
                reservaRepository.save(reserva);
            } else {
                throw new RuntimeException("No se puede cancelar una reserva confirmada");
            }
        }
}
