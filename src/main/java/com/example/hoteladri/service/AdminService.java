package com.example.hoteladri.service;

import com.example.hoteladri.model.Admin;
import com.example.hoteladri.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    
        @Autowired
        private PasswordEncoder passwordEncoder;
    
        @Autowired
        private IAdminRepository administradorRespository;
    
        public List<Admin> obtainAllUsers() {
            List<Admin> administradores = administradorRespository.findAll();
            return administradores;
        }
    
        public Admin keepUser(Admin administrador) {
            administrador.setPassword(passwordEncoder.encode(administrador.getPassword()));
            return administradorRespository.save(administrador);
        }

        public Admin findByEmail(String email) {
            return administradorRespository.findByEmail(email);
        }
        
}
