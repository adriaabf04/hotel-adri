package com.example.hoteladri.controller;

import com.example.hoteladri.model.Admin;
import com.example.hoteladri.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdminController {

        @Autowired
        private AdminService administradorService;
    
        @GetMapping
        public List<Admin> obtainAllUsers() {
            return administradorService.obtainAllUsers();
        }
    
        @PostMapping
        public Admin keepUser(@RequestBody Admin administrador) {
            return administradorService.keepUser(administrador);
        }
}
