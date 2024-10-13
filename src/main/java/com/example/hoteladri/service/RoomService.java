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

        public RoomDTO getRoomByNumberRoom(int numberRoom) {
            Room room = roomRepository.findByNumberRoom(numberRoom);
            return new RoomDTO(room.getNumberRoom(), room.getType(), room.getPrice(), room.getStatus());
        }
    
        public RoomDTO saveRoom(Room room) {
            Room roomSaved = roomRepository.save(room);
            return new RoomDTO(roomSaved.getNumberRoom(), roomSaved.getType(), roomSaved.getPrice(), roomSaved.getStatus());
        }

        public void deleteRoom(Room room) {
            roomRepository.delete(room);
        }

        public RoomDTO updateRoom(Room room) {
            Room roomUpdated = roomRepository.save(room);
            return new RoomDTO(roomUpdated.getNumberRoom(), roomUpdated.getType(), roomUpdated.getPrice(), roomUpdated.getStatus());
        }

        public List<RoomDTO> getAvailableRooms() {
            List<Room> rooms = roomRepository.findByStatus(RoomStatus.DISPONIBLE);
            List<RoomDTO> roomDTOs = new ArrayList<>();
            for (Room room : rooms) {
                RoomDTO roomDTO = new RoomDTO(room.getNumberRoom(), room.getType(), room.getPrice(), room.getStatus());
                roomDTOs.add(roomDTO);
            }
            return roomDTOs;
        }
}
