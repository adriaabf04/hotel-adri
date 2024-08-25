package com.example.hoteladri.service;

import com.example.hoteladri.model.Administrador;
import com.example.hoteladri.repository.AdministradorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {
    
        @Autowired
        private AdministradorRespository administradorRespository;
    
        public List<Administrador> obtenerTodosLosUsuarios() {
            return administradorRespository.findAll();
        }
    
        public Administrador guardarUsuario(Administrador administrador) {
            return administradorRespository.save(administrador);
        }
}
