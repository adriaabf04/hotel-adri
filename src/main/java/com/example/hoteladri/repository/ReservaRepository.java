package com.example.hoteladri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hoteladri.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}
