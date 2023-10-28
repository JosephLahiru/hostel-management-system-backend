package me.mtron.hostelmanagementsystembackend.service.impl;

import me.mtron.hostelmanagementsystembackend.DTO.EmployeeDTO;
import me.mtron.hostelmanagementsystembackend.DTO.LoginDTO;
import me.mtron.hostelmanagementsystembackend.httpentities.Employee;
import me.mtron.hostelmanagementsystembackend.payload.response.LoginMessage;
import me.mtron.hostelmanagementsystembackend.repo.EmployeeRepo;
import me.mtron.hostelmanagementsystembackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeIMPL implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(employee);

        return employee.getEmployeeName();
    }

    @Override
    public LoginMessage loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee = employeeRepo.findByEmail(loginDTO.getEmail());
        if(employee!=null){
            String password = loginDTO.getPassword();
            String encodedPassword = employee.getPassword();
            Boolean isPwdCorrect = passwordEncoder.matches(password, encodedPassword);
            if(isPwdCorrect){
                Optional<Employee> employee1 = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if(employee1.isPresent()){
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
}
