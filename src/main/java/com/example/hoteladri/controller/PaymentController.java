package com.example.hoteladri.controller;

import com.example.hoteladri.model.Payment;
import com.example.hoteladri.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PaymentController {
    @Autowired
    private PaymentService pagoService;

    @GetMapping
    public List<Payment> obtaiPayments() {
        return pagoService.obtaiPayments();
    }

    @GetMapping()
    @RequestMapping("/{id}")
    public Payment obtainPaymentById(@PathVariable Long id) {
        return pagoService.obtainPaymentById(id);
    }
}
