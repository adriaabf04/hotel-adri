package com.example.hoteladri.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hoteladri.model.Booking;
import com.example.hoteladri.model.Client;

public interface IBookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByClient(Client client);
}
