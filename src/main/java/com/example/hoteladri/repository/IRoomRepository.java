package com.example.hoteladri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hoteladri.model.RoomStatus;
import com.example.hoteladri.model.Room;

public interface IRoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByStatus(RoomStatus status);
}
