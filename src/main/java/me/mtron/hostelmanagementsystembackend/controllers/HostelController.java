package me.mtron.hostelmanagementsystembackend.controllers;

import me.mtron.hostelmanagementsystembackend.httpentities.Hostel;
import me.mtron.hostelmanagementsystembackend.repo.HostelRepo;
import me.mtron.hostelmanagementsystembackend.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class HostelController {
    @Autowired
    private HostelRepo hostelRepo;

    @Autowired
    private HostelService hostelService;

    @PostMapping("/hostel")
    public ResponseEntity<Hostel> saveHostel(@RequestBody Hostel h) {
        h = this.hostelService.handleRegistration(h);
        return ResponseEntity.ok().body(h);
    }

    @GetMapping("/hostel")
    public ResponseEntity<List<Hostel>> getAllHostels() {
        List<Hostel> all = hostelRepo.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/hostel/{id}")
    public ResponseEntity<Optional<Hostel>> findHostel(@PathVariable Long id) {
        Optional<Hostel> h = this.hostelRepo.findById(id);
        return ResponseEntity.ok().body(h);
    }

    @DeleteMapping("/hostel/{id}")
    public ResponseEntity<Optional<Hostel>> deleteHostel(@PathVariable Long id) {
        if (hostelRepo.existsById(id)) {
            this.hostelRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).build();
    }
}
