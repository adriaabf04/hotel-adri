package com.example.hoteladri.service;

import com.example.hoteladri.model.Cliente;
import com.example.hoteladri.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodosLosUsuarios() {
        return clienteRepository.findAll();
    }

    public Cliente guardarUsuario(Cliente usuario) {
        return clienteRepository.save(usuario);
    }

}