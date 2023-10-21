package me.mtron.hostelmanagementsystembackend.controllers;

import me.mtron.hostelmanagementsystembackend.httpentities.Room;
import me.mtron.hostelmanagementsystembackend.repo.RoomRepo;
import me.mtron.hostelmanagementsystembackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<Room> saveRoom(@RequestBody Room r) {
        r = this.roomService.handleRegistration(r);
        return ResponseEntity.ok().body(r);
    }

    @GetMapping("/room")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> all = roomRepo.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Optional<Room>> findRoom(@PathVariable Long id) {
        Optional<Room> r = this.roomRepo.findById(id);
        return ResponseEntity.ok().body(r);
    }

    @DeleteMapping("/room/{id}")
    public ResponseEntity<Optional<Room>> deleteRoom(@PathVariable Long id) {
        if (roomRepo.existsById(id)) {
            this.roomRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).build();
    }
}
