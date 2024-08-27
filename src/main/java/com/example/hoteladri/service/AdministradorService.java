package com.example.hoteladri.service;

import com.example.hoteladri.model.Administrador;
import com.example.hoteladri.repository.AdministradorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministradorService {
    
        @Autowired
        private PasswordEncoder passwordEncoder;
    
        @Autowired
        private AdministradorRespository administradorRespository;
    
        public List<Administrador> obtenerTodosLosUsuarios() {
            List<Administrador> administradores = administradorRespository.findAll();
            return administradores;
        }
    
        public Administrador guardarUsuario(Administrador administrador) {
            administrador.setPassword(passwordEncoder.encode(administrador.getPassword()));
            return administradorRespository.save(administrador);
        }

        /* Encontrar por email */
        public Administrador encontrarPorEmail(String email) {
            return administradorRespository.findByEmail(email);
        }
        
}
