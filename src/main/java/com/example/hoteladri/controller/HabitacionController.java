package com.example.hoteladri.controller;

import com.example.hoteladri.model.Habitacion;
import com.example.hoteladri.service.HabitacionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
            public Habitacion guardarHabitacion(@RequestBody Habitacion habitacion) {
                return habitacionRepository.guardarHabitacion(habitacion);
            }
}
