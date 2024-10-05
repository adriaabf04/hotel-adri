package com.example.hoteladri.service;

import com.example.hoteladri.dto.AdminDTO;
import com.example.hoteladri.model.Admin;
import com.example.hoteladri.repository.IAdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class AdminService {
    
        @Autowired
        private PasswordEncoder passwordEncoder;
    
        @Autowired
        private IAdminRepository administradorRespository;
    
        public ArrayList<AdminDTO> obtainAllUsers() {
            List<Admin> administradores = administradorRespository.findAll();
            ArrayList<AdminDTO> adminDTOList = new ArrayList<>();
            for (Admin administrador : administradores) {
                AdminDTO adminDTO = new AdminDTO(administrador.getName(), administrador.getEmail());
                adminDTOList.add(adminDTO);
            }
            return adminDTOList;
        }
    
        public AdminDTO keepUser(Admin administrador) {
            administrador.setPassword(passwordEncoder.encode(administrador.getPassword()));
            administradorRespository.save(administrador);
            AdminDTO adminDTO = new AdminDTO(administrador.getName(), administrador.getEmail());
            return adminDTO;
        }

        public AdminDTO findByEmail(String email) {
            Admin admin = administradorRespository.findByEmail(email);
            AdminDTO adminDTO = new AdminDTO(admin.getName(), admin.getEmail());
            return adminDTO;
        }

        public Admin findByEmailDetail(String email) {
            Admin admin = administradorRespository.findByEmail(email);
            return admin;
        }
}
