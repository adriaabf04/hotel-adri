package com.example.hoteladri.controller;

import com.example.hoteladri.model.Habitacion;
import com.example.hoteladri.service.HabitacionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {
        
            @Autowired
            private HabitacionService habitacionRepository;
        
            @GetMapping
            public List<Habitacion> obtenerHabitaciones() {
                return habitacionRepository.obtenerTodasLasHabitaciones();
            }
        
            @PostMapping
            @RequestMapping("/crear")
            public Habitacion guardarHabitacion(@RequestBody Habitacion habitacion) {
                return habitacionRepository.guardarHabitacion(habitacion);
            }

            @DeleteMapping
            @RequestMapping("/eliminar")
            public void eliminarHabitacion(@RequestBody Habitacion habitacion) {
                habitacionRepository.eliminarHabitacion(habitacion);
            }

            @GetMapping
            @RequestMapping("/disponibles")
            public List<Habitacion> obtenerHabitacionesDisponibles() {
                return habitacionRepository.obtenerHabitacionesDisponibles();
            }

            @PostMapping
            @RequestMapping("/actualizar")
            public Habitacion actualizarHabitacion(@RequestBody Habitacion habitacion) {
                return habitacionRepository.actualizarHabitacion(habitacion);
            }
}
