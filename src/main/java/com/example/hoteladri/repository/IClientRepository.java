package com.example.hoteladri.repository;

import com.example.hoteladri.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {

}