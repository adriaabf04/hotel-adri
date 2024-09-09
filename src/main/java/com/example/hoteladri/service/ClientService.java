package com.example.hoteladri.service;

import com.example.hoteladri.model.Client;
import com.example.hoteladri.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private IClientRepository clienteRepository;

    public List<Client> obtainAllUsers() {
        return clienteRepository.findAll();
    }

    public Client keepUser(Client usuario) {
        return clienteRepository.save(usuario);
    }

    public Client keepUserById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Client updateUser(Client usuario) {
        return clienteRepository.save(usuario);
    }

}