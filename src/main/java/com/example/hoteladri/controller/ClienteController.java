package com.example.hoteladri.controller;

import com.example.hoteladri.model.Cliente;
import com.example.hoteladri.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/crear")
    public Cliente guardarUsuario(@RequestBody Cliente cliente) {
        return clienteRepository.guardarUsuario(cliente);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Cliente obtenerUsuarioPorId(@PathVariable Long id) {
        return clienteRepository.obtenerUsuarioPorId(id);
    }

    @DeleteMapping
    @RequestMapping("/eliminar/{id}")
    public void eliminarUsuarioPorId(@PathVariable Long id) {
        clienteRepository.eliminarUsuarioPorId(id);
    }

    @PostMapping
    @RequestMapping("/actualizar")
    public Cliente actualizarUsuario(@RequestBody Cliente cliente) {
        return clienteRepository.actualizarUsuario(cliente);
    }


}