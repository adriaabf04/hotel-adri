package com.example.hoteladri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hoteladri.model.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    
}
