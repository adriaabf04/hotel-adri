package com.example.hoteladri.service;

import com.example.hoteladri.model.Payment;
import com.example.hoteladri.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private IPaymentRepository pagoRepository;

    public List<Payment> obtaiPayments() {
        return pagoRepository.findAll();
    }

    public Payment obtainPaymentById(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }
}