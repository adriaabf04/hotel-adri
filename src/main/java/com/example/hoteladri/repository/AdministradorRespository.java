package com.example.hoteladri.repository;

import com.example.hoteladri.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRespository extends JpaRepository<Administrador, Long> {
    
}
