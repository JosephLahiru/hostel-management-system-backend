package me.mtron.hostelmanagementsystembackend.service;

import me.mtron.hostelmanagementsystembackend.httpentities.Student;
import me.mtron.hostelmanagementsystembackend.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public Student handleRegistration(Student s){return this.studentRepo.save(s);}
}
