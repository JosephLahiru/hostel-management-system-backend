package me.mtron.hostelmanagementsystembackend.controllers;

import me.mtron.hostelmanagementsystembackend.httpentities.Property;
import me.mtron.hostelmanagementsystembackend.repo.PropertyRepo;
import me.mtron.hostelmanagementsystembackend.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class PropertyController {
    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/property")
    public ResponseEntity<Property> saveProperty(@RequestBody Property r) {
        r = this.propertyService.handleRegistration(r);
        return ResponseEntity.ok().body(r);
    }

    @GetMapping("/property")
    public ResponseEntity<List<Property>> getAllPropertys() {
        List<Property> all = propertyRepo.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/property/{id}")
    public ResponseEntity<Optional<Property>> findProperty(@PathVariable Long id) {
        Optional<Property> r = this.propertyRepo.findById(id);
        return ResponseEntity.ok().body(r);
    }

    @DeleteMapping("/property/{id}")
    public ResponseEntity<Optional<Property>> deleteProperty(@PathVariable Long id) {
        if (propertyRepo.existsById(id)) {
            this.propertyRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).build();
    }
}
