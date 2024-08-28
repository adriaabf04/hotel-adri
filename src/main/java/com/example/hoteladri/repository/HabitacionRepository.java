package com.example.hoteladri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hoteladri.model.EstadoHabitacion;
import com.example.hoteladri.model.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByEstado(EstadoHabitacion estado);
}
