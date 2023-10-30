package me.mtron.hostelmanagementsystembackend.controllers;

import me.mtron.hostelmanagementsystembackend.models.ApplicationUser;
import me.mtron.hostelmanagementsystembackend.models.LoginDTO;
import me.mtron.hostelmanagementsystembackend.models.LoginResponseDTO;
import me.mtron.hostelmanagementsystembackend.models.RegistrationDTO;
import me.mtron.hostelmanagementsystembackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authService.registerUser(body.getRegistrationNum(), body.getUsername(), body.getEmail(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginDTO body){
        return authService.loginUser(body.getUsername(), body.getPassword());
    }
}
