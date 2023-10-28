package me.mtron.hostelmanagementsystembackend.controllers;

import me.mtron.hostelmanagementsystembackend.httpentities.Complaint;
import me.mtron.hostelmanagementsystembackend.repo.ComplaintRepo;
import me.mtron.hostelmanagementsystembackend.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class ComplaintController {
    @Autowired
    private ComplaintRepo complaintRepo;

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/complaint")
    public ResponseEntity<Complaint> saveComplaint(@RequestBody Complaint c) {
        c = this.complaintService.handleRegistration(c);
        return ResponseEntity.ok().body(c);
    }

    @GetMapping("/complaint")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        List<Complaint> all = complaintRepo.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/complaint/{id}")
    public ResponseEntity<Optional<Complaint>> findComplaint(@PathVariable Long id) {
        Optional<Complaint> c = this.complaintRepo.findById(id);
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/complaint/{id}")
    public ResponseEntity<Optional<Complaint>> deleteComplaint(@PathVariable Long id) {
        if (complaintRepo.existsById(id)) {
            this.complaintRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).build();
    }
}
