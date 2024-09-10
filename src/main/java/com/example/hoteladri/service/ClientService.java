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
            ClientDTO clientDTO = new ClientDTO(user.getId(), user.getName(), user.getSurname(), user.getEmail());
            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
    }

    public ClientDTO keepUser(Client usuario) {
        clienteRepository.save(usuario);
        ClientDTO clientDTO = new ClientDTO(usuario.getId(), usuario.getName(), usuario.getSurname(), usuario.getEmail());
        return clientDTO;
    }

    public ClientDTO keepUserById(Long id) {
        Client client = clienteRepository.findById(id).orElse(null);
        ClientDTO clientDTO = new ClientDTO(client.getId(),client.getName(), client.getSurname(), client.getEmail());
        return clientDTO;
    }

    public void deleteUserById(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClientDTO updateUser(Client usuario, Long id) {
        Client client = clienteRepository.findById(id).orElse(null);
        client.setName(usuario.getName());
        client.setSurname(usuario.getSurname());
        client.setEmail(usuario.getEmail());
        ClientDTO clientDTO = new ClientDTO(client.getId(), client.getName(), client.getSurname(), client.getEmail());
        return clientDTO;
    }

}