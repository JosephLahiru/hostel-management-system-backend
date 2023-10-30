package me.mtron.hostelmanagementsystembackend.service;

import me.mtron.hostelmanagementsystembackend.models.ApplicationUser;
import me.mtron.hostelmanagementsystembackend.models.Role;
import me.mtron.hostelmanagementsystembackend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the user details service");

        return userRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User is not Valid"));
    }
}
