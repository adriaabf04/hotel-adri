package com.example.hoteladri.service;

import com.example.hoteladri.model.EstadoHabitacion;
import com.example.hoteladri.model.Habitacion;
import com.example.hoteladri.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionService {
       @Autowired
        private HabitacionRepository administradorRespository;
    
        public List<Habitacion> obtenerTodasLasHabitaciones() {
            return administradorRespository.findAll();
        }
    
        public Habitacion guardarHabitacion(Habitacion habitacion) {
            return administradorRespository.save(habitacion);
        }

        public void eliminarHabitacion(Habitacion habitacion) {
            administradorRespository.delete(habitacion);
        }

        public Habitacion actualizarHabitacion(Habitacion habitacion) {
            return administradorRespository.save(habitacion);
        }

        public List<Habitacion> obtenerHabitacionesDisponibles() {
            return administradorRespository.findByEstado(EstadoHabitacion.DISPONIBLE);
        }
}
