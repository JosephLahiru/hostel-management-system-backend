package me.mtron.hostelmanagementsystembackend.service.impl;

import me.mtron.hostelmanagementsystembackend.DTO.UserDTO;
import me.mtron.hostelmanagementsystembackend.DTO.LoginDTO;
import me.mtron.hostelmanagementsystembackend.httpentities.User;
import me.mtron.hostelmanagementsystembackend.payload.response.LoginMessage;
import me.mtron.hostelmanagementsystembackend.repo.UserRepo;
import me.mtron.hostelmanagementsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );

        userRepo.save(user);

        return user.getUserName();
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user = userRepo.findByEmail(loginDTO.getEmail());
        if(user !=null){
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdCorrect = passwordEncoder.matches(password, encodedPassword);
            if(isPwdCorrect){
                Optional<User> user1 = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if(user1.isPresent()){
                    return new LoginMessage("Login Success!", true);
                }else{
                    return new LoginMessage("Login Failed!", false);
                }
            }else{
                return new LoginMessage("Invalid Credentials!", false);
            }
        }else{
            return new LoginMessage("Invalid Credentials!", false);
        }
    }

    @Override
    public boolean emailExists(String email) {
        return userRepo.findByEmail(email) != null;
    }
}
