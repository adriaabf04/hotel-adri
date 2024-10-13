package com.example.hoteladri.service;

import com.example.hoteladri.model.RoomStatus;
import com.example.hoteladri.dto.RoomDTO;
import com.example.hoteladri.model.Room;
import com.example.hoteladri.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
       @Autowired
        private IRoomRepository roomRepository;
    
        public ArrayList<RoomDTO> getAllRooms() {
            List<Room> rooms = roomRepository.findAll();
            ArrayList<RoomDTO> roomDTOs = new ArrayList<>();
            for (Room room : rooms) {
                RoomDTO roomDTO = new RoomDTO(room.getNumberRoom(), room.getType(), room.getPrice(), room.getStatus());
                roomDTOs.add(roomDTO);
            }
            return roomDTOs;
        }

        public RoomDTO getRoomById(Long id) {
            Room room = roomRepository.findById(id).orElse(null);
            if (room != null) {
                return new RoomDTO(room.getNumberRoom(), room.getType(), room.getPrice(), room.getStatus());
            } else {
                throw new RuntimeException("Room not found");
            }
        }
    
        public Room saveRoom(Room room) {
            return roomRepository.save(room);
        }

        public void deleteRoom(Room room) {
            roomRepository.delete(room);
        }

        public Room updateRoom(Room room) {
            return roomRepository.save(room);
        }

        public List<Room> getAvailableRooms() {
            return roomRepository.findByStatus(RoomStatus.DISPONIBLE);
        }
}
