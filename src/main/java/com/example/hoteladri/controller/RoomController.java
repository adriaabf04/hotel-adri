package com.example.hoteladri.controller;

import com.example.hoteladri.dto.RoomDTO;
import com.example.hoteladri.model.Room;
import com.example.hoteladri.service.RoomService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitaciones")
public class RoomController {
        
    @Autowired
    private RoomService habitacionRepository;
        
    @GetMapping
    public ArrayList<RoomDTO> obtainAllRooms() {
        return habitacionRepository.getAllRooms();
    }

    @GetMapping
    @RequestMapping("/{numberRoom}")
    public RoomDTO obtainRoomByNumberRoom(@PathVariable int numberRoom) {
        return habitacionRepository.getRoomByNumberRoom(numberRoom);
    }
        
    @PostMapping
    @RequestMapping("/crear")
    public Room keepRoom(@RequestBody Room habitacion) {
        return habitacionRepository.saveRoom(habitacion);
    }

    @DeleteMapping
    @RequestMapping("/eliminar")
    public void deleteRoom(@RequestBody Room habitacion) {
        habitacionRepository.deleteRoom(habitacion);
    }

    @GetMapping
    @RequestMapping("/disponibles")
    public List<Room> obtainAvailableRooms() {
        return habitacionRepository.getAvailableRooms();
    }

    @PostMapping
    @RequestMapping("/actualizar")
    public Room updateRoom(@RequestBody Room habitacion) {
        return habitacionRepository.updateRoom(habitacion);
    }
}
