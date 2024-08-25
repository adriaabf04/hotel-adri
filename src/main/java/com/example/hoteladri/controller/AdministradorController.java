package com.example.hoteladri.controller;

import com.example.hoteladri.model.Administrador;
import com.example.hoteladri.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {
    
        @Autowired
        private AdministradorService administradorRepository;
    
        @GetMapping
        public List<Administrador> obtenerUsuarios() {
            return administradorRepository.obtenerTodosLosUsuarios();
        }
    
        @PostMapping
        public Administrador guardarUsuario(@RequestBody Administrador administrador) {
            return administradorRepository.guardarUsuario(administrador);
        }
}
