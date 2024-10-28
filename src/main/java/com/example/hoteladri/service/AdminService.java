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
        private IAdminRepository administratorRespository;
    
        public ArrayList<AdminDTO> obtainAllUsers() {
            List<Admin> administrators = administratorRespository.findAll();
            ArrayList<AdminDTO> adminDTOList = new ArrayList<>();
            for (Admin administrator : administrators) {
                AdminDTO adminDTO = new AdminDTO(administrator.getName(), administrator.getEmail());
                adminDTOList.add(adminDTO);
            }
            return adminDTOList;
        }
    
        public AdminDTO keepUser(Admin administrator) {
            administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
            administratorRespository.save(administrator);
            AdminDTO adminDTO = new AdminDTO(administrator.getName(), administrator.getEmail());
            return adminDTO;
        }

        public AdminDTO findByEmail(String email) {
            Admin admin = administratorRespository.findByEmail(email);
            AdminDTO adminDTO = new AdminDTO(admin.getName(), admin.getEmail());
            return adminDTO;
        }

        public Admin findByEmailDetail(String email) {
            Admin admin = administratorRespository.findByEmail(email);
            return admin;
        }
}
