package me.mtron.hostelmanagementsystembackend.service;

import me.mtron.hostelmanagementsystembackend.DTO.UserDTO;
import me.mtron.hostelmanagementsystembackend.DTO.LoginDTO;
import me.mtron.hostelmanagementsystembackend.payload.response.LoginMessage;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginMessage loginUser(LoginDTO loginDTO);

    boolean emailExists(String email);
}