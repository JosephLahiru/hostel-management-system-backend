package me.mtron.hostelmanagementsystembackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class GeneralController {
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> welcome() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "online");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/endpoints", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List<Map<String, String>>>> showEndpoints() {
        Map<String, List<Map<String, String>>> response = new HashMap<>();
        List<Map<String, String>> endpoints = new ArrayList<>();

        endpoints.add(addEndpoint("Check Online", "Get", "Endpoint for Checking API status", "/api/", "no"));
        endpoints.add(addEndpoint("View Endpoints", "Get", "Endpoint for viewing all Endpoints", "/api/endpoints", "no"));
        endpoints.add(addEndpoint("Login", "Post", "Endpoint for user login", "/api/user/login", "yes"));
        endpoints.add(addEndpoint("Signup", "Post", "Endpoint for user signup", "/api/user/signup", "yes"));
        endpoints.add(addEndpoint("Get Hostel", "Get", "Endpoint for get all Hostel information", "/api/hostel", "yes"));
        endpoints.add(addEndpoint("Add Hostel", "Post", "Endpoint for add a Hostel", "/api/hostel", "yes"));
        endpoints.add(addEndpoint("Get Complaint", "Get", "Endpoint for get all Complaint information", "/api/complaint", "yes"));
        endpoints.add(addEndpoint("Add Complaint", "Post", "Endpoint for add a Complaint", "/api/complaint", "yes"));
        endpoints.add(addEndpoint("Get Property", "Get", "Endpoint for get all Property information", "/api/property", "yes"));
        endpoints.add(addEndpoint("Add Property", "Post", "Endpoint for add a Property", "/api/property", "yes"));
        endpoints.add(addEndpoint("Get Room", "Get", "Endpoint for get all Room information", "/api/room", "yes"));
        endpoints.add(addEndpoint("Add Room", "Post", "Endpoint for add a Room", "/api/room", "yes"));
        endpoints.add(addEndpoint("Get Student", "Get", "Endpoint for get all Student information", "/api/student", "yes"));
        endpoints.add(addEndpoint("Add Student", "Post", "Endpoint for add a Student", "/api/student", "yes"));

        response.put("endpoints", endpoints);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private Map<String, String> addEndpoint(String name, String type, String description, String path, String auth){
        Map<String, String> endpoint = new HashMap<>();
        endpoint.put("name", name);
        endpoint.put("type", type);
        endpoint.put("description", description);
        endpoint.put("path", path);
        endpoint.put("required_authentication", auth);

        return endpoint;
    }

}
