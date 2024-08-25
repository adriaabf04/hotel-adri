package com.example.hoteladri.service;

import com.example.hoteladri.model.Reserva;
import com.example.hoteladri.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
        private ReservaRepository administradorRespository;
    
        public List<Reserva> obtenerTodasLasReservas() {
            return administradorRespository.findAll();
        }
    
        public Reserva guardarReserva(Reserva reserva) {
            return administradorRespository.save(reserva);
        }
}
