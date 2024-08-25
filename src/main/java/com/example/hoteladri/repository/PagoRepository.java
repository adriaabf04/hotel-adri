package com.example.hoteladri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hoteladri.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    
}
