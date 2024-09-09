package com.example.hoteladri.repository;

import com.example.hoteladri.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin, Long> {
    /* Encontrar usuario por email */
    Admin findByEmail(String email);
}
