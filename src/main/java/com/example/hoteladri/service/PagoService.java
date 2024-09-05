package com.example.hoteladri.service;

import com.example.hoteladri.model.Pago;
import com.example.hoteladri.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {
    @Autowired
        private PagoRepository pagoRepository;
    
        public List<Pago> obtenerTodosLosPagos() {
            return pagoRepository.findAll();
        }
    
        public Pago obtenerPagoPorId(Long id) {
            return pagoRepository.findById(id).orElse(null);
        }
}
