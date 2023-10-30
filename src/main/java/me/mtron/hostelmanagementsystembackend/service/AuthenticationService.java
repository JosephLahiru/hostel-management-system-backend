package me.mtron.hostelmanagementsystembackend.service;

import jakarta.transaction.Transactional;
import me.mtron.hostelmanagementsystembackend.models.ApplicationUser;
import me.mtron.hostelmanagementsystembackend.models.LoginResponseDTO;
import me.mtron.hostelmanagementsystembackend.models.Role;
import me.mtron.hostelmanagementsystembackend.repo.RoleRepo;
import me.mtron.hostelmanagementsystembackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    public ApplicationUser registerUser (String registrationNum, String username, String email, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepo.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepo.save(new ApplicationUser(0, registrationNum, username, email, encodedPassword, authorities));
    }

    public LoginResponseDTO loginUser(String username, String password){

        try{
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDTO(userRepo.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
            return new LoginResponseDTO(null, "");
        }
    }
}
