package com.example.hoteladri.service;

import com.example.hoteladri.dto.ClientDTO;
import com.example.hoteladri.model.Client;
import com.example.hoteladri.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private IClientRepository clienteRepository;

    public ArrayList<ClientDTO> obtainAllUsers() {
        List<Client> users = clienteRepository.findAll();
        ArrayList<ClientDTO> clientDTOList = new ArrayList<>();
        for (Client user : users) {
            ClientDTO clientDTO = new ClientDTO(user.getName(), user.getSurname(), user.getEmail());
            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
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