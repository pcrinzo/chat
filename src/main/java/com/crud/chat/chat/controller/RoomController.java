package com.crud.chat.chat.controller;

import com.crud.chat.chat.expetion.ResourceNotFoundExcepetion;
import com.crud.chat.chat.model.Room;
import com.crud.chat.chat.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

@RestController @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId)
            throws ResourceNotFoundExcepetion {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundExcepetion("Room not found:" + roomId));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updadeRoom(@PathVariable(value = "id") Long roomId,
                                           @Valid @RequestBody Room roomDetails) throws ResourceNotFoundExcepetion {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundExcepetion("Room not found for this ID: " + roomId));
        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStartHour(roomDetails.getStartHour());
        room.setEndHour(roomDetails.getEndHour());
        final Room uptadeRoom= roomRepository.save(room);
        return ResponseEntity.ok(uptadeRoom);
    }

    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId)
        throws ResourceNotFoundExcepetion{
        Room room= roomRepository.findById(roomId)
                .orElseThrow(()->new ResourceNotFoundExcepetion("Room not found for this ID: "+roomId));

        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}