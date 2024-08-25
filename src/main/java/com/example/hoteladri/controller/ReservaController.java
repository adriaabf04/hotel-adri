package com.example.hoteladri.controller;

import com.example.hoteladri.model.Reserva;
import com.example.hoteladri.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        
        @PostMapping
        public Reserva guardarReserva(@RequestBody Reserva reserva) {
            return administradorRepository.guardarReserva(reserva);
        }
}
