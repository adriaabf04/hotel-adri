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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuario", description = "API para la gestión de usuarios")
public class ClientController {

    @Autowired
    private ClientService clienteRepository;

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de todos los usuarios")
    public ArrayList<ClientDTO> obtainAllUsers() {
        return clienteRepository.obtainAllUsers();
    }

    @PostMapping("/crear")
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario en el sistema")
    public ClientDTO keepUser(@RequestBody Client cliente) {
        return clienteRepository.keepUser(cliente);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un usuario por ID", description = "Devuelve un usuario según su ID")
    public ClientDTO getUserById(@PathVariable Long id) {
        return clienteRepository.keepUserById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Eliminar un usuario por ID", description = "Elimina un usuario del sistema")
    public void deleteUserById(@PathVariable Long id) {
        clienteRepository.deleteUserById(id);
    }

    @PostMapping("/actualizar/{id}")
    @Operation(summary = "Actualizar un usuario", description = "Actualiza los datos de un usuario existente")
    public ClientDTO updateUser(@RequestBody Client cliente, @PathVariable Long id) {
        return clienteRepository.updateUser(cliente, id);
    }
}
