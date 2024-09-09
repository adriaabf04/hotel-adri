package com.example.hoteladri.service;

import com.example.hoteladri.model.RoomStatus;
import com.example.hoteladri.model.Room;
import com.example.hoteladri.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
       @Autowired
        private IRoomRepository habitacionRepository;
    
        public List<Room> obtainAllRooms() {
            return habitacionRepository.findAll();
        }
    
        public Room keepRoom(Room habitacion) {
            return habitacionRepository.save(habitacion);
        }

        public void deleteRoom(Room habitacion) {
            habitacionRepository.delete(habitacion);
        }

        public Room updateRoom(Room habitacion) {
            return habitacionRepository.save(habitacion);
        }

        public List<Room> obtainAvailableRooms() {
            return habitacionRepository.findByStatus(RoomStatus.DISPONIBLE);
        }
}
