package com.example.hoteladri.controller;

import com.example.hoteladri.model.Admin;
import com.example.hoteladri.dto.AdminDTO;
import com.example.hoteladri.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/administradores")
public class AdminController {

        @Autowired
        private AdminService adminService;
    
        @GetMapping
        public ArrayList<AdminDTO> obtainAllUsers() {
            return adminService.obtainAllUsers();
        }
    
        @PostMapping
        public AdminDTO keepUser(@RequestBody Admin administrador) {
            return adminService.keepUser(administrador);
        }

        @GetMapping
        @RequestMapping("/{email}")
        public Admin findById(@PathVariable String email) {
            return adminService.findByEmail(email);
        }
}
