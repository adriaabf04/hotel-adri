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
    private IClientRepository clientRepository;

    public ArrayList<ClientDTO> obtainAllUsers() {
        List<Client> users = clientRepository.findAll();
        ArrayList<ClientDTO> clientDTOList = new ArrayList<>();
        for (Client user : users) {
            ClientDTO clientDTO = new ClientDTO(user.getId(), user.getName(), user.getSurname(), user.getEmail());
            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
    }

    public ClientDTO keepUser(Client user) {
        clientRepository.save(user);
        ClientDTO clientDTO = new ClientDTO(user.getId(), user.getName(), user.getSurname(), user.getEmail());
        return clientDTO;
    }

    public ClientDTO keepUserById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        ClientDTO clientDTO = new ClientDTO(client.getId(),client.getName(), client.getSurname(), client.getEmail());
        return clientDTO;
    }

    public void deleteUserById(Long id) {
        clientRepository.deleteById(id);
    }

    public ClientDTO updateUser(Client user, Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        client.setName(user.getName());
        client.setSurname(user.getSurname());
        client.setEmail(user.getEmail());
        clientRepository.save(client);
        ClientDTO clientDTO = new ClientDTO(client.getId(), client.getName(), client.getSurname(), client.getEmail());
        return clientDTO;
    }

}