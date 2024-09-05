package com.example.hoteladri.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hoteladri.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByClienteId(Long clienteId);
}
