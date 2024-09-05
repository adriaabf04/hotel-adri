package com.example.hoteladri.controller;

import com.example.hoteladri.model.Reserva;
import com.example.hoteladri.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
        
        @Autowired
        private ReservaService administradorRepository;
        
        @GetMapping
        public List<Reserva> obtenerReservas() {
            return administradorRepository.obtenerTodasLasReservas();
        }

        @GetMapping("/{id}")
        public Reserva obtenerReserva(@PathVariable Long id) {
            return administradorRepository.obtenerReservaPorId(id);
        }

        @GetMapping("/cliente/{cliente}")
        public List<Reserva> obtenerReservasPorCliente(@PathVariable Long cliente) {
            return administradorRepository.obtenerReservasPorCliente(cliente);
        }
        
        @PostMapping
        @RequestMapping("/cliente/{cliente}/crear")
        public Reserva guardarReserva(@PathVariable Long cliente,  @RequestBody Reserva reserva) {
            return administradorRepository.guardarReserva(reserva, cliente);
        }

        @PostMapping
        @RequestMapping("/cliente/{cliente}/confirmar")
        public Reserva confirmarReserva(@PathVariable Long cliente,  @RequestBody Reserva reserva) {
            return administradorRepository.confirmarReserva(reserva, cliente);
        }

        @DeleteMapping("/cliente/{cliente}/cancelar")
        public void cancelarReserva(@PathVariable Long cliente, @RequestBody Reserva reserva) {
            administradorRepository.cancelarReserva(reserva, cliente);
        }
        
}
