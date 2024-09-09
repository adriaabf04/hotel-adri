package com.example.hoteladri.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hoteladri.model.Booking;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByClienteId(Long clienteId);
}
