package com.example.hoteladri.controller;

import com.example.hoteladri.model.Client;
import com.example.hoteladri.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.example.hoteladri.dto.ClientDTO;
@RestController
@RequestMapping("/usuarios")
public class ClientController {

    @Autowired
    private ClientService clienteRepository;

    @GetMapping
    
    public ArrayList<ClientDTO> obtainAllUsers() {
        return clienteRepository.obtainAllUsers();
    }

    @PostMapping
    @RequestMapping("/crear")
    public Client keepUser(@RequestBody Client cliente) {
        return clienteRepository.keepUser(cliente);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Client keepUserById(@PathVariable Long id) {
        return clienteRepository.keepUserById(id);
    }

    @DeleteMapping
    @RequestMapping("/eliminar/{id}")
    public void deleteUserById(@PathVariable Long id) {
        clienteRepository.deleteUserById(id);
    }

    @PostMapping
    @RequestMapping("/actualizar")
    public Client updateUser(@RequestBody Client cliente) {
        return clienteRepository.updateUser(cliente);
    }


}