package me.mtron.hostelmanagementsystembackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GeneralController {
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> welcome() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "online");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/endpoints", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> showEndpoints() {
        Map<String, String> response = new HashMap<>();
        List<String> endpoints = Arrays.asList("api/user/login", "/api/user/signup", "/api/hostel");
        response.put("endpoints", endpoints.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
