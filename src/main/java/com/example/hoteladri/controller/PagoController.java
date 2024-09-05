package com.example.hoteladri.controller;

import com.example.hoteladri.model.Pago;
import com.example.hoteladri.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> obtenerPagos() {
        return pagoService.obtenerTodosLosPagos();
    }

    @GetMapping()
    @RequestMapping("/{id}")
    public Pago obtenerPago(Long id) {
        return pagoService.obtenerPagoPorId(id);
    }
}
