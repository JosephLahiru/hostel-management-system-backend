package me.mtron.hostelmanagementsystembackend.service;

import me.mtron.hostelmanagementsystembackend.DTO.EmployeeDTO;
import me.mtron.hostelmanagementsystembackend.DTO.LoginDTO;
import me.mtron.hostelmanagementsystembackend.payload.response.LoginMessage;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginMessage loginEmployee(LoginDTO loginDTO);

    boolean emailExists(String email);
}