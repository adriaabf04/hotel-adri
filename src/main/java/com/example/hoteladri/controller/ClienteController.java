package com.example.hoteladri.controller;

import com.example.hoteladri.model.Cliente;
import com.example.hoteladri.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ClienteController {

    @Autowired
    private ClienteService clienteRepository;

    @GetMapping
    public List<Cliente> obtenerUsuarios() {
        return clienteRepository.obtenerTodosLosUsuarios();
    }

    @PostMapping
    public Cliente guardarUsuario(@RequestBody Cliente cliente) {
        return clienteRepository.guardarUsuario(cliente);
    }
}