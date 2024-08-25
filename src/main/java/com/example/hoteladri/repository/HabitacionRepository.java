package com.example.hoteladri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hoteladri.model.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    
}
