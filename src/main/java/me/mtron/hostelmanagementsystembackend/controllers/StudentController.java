package me.mtron.hostelmanagementsystembackend.controllers;

import me.mtron.hostelmanagementsystembackend.httpentities.Student;
import me.mtron.hostelmanagementsystembackend.repo.StudentRepo;
import me.mtron.hostelmanagementsystembackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student r) {
        r = this.studentService.handleRegistration(r);
        return ResponseEntity.ok().body(r);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> all = studentRepo.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> findStudent(@PathVariable Long id) {
        Optional<Student> r = this.studentRepo.findById(id);
        return ResponseEntity.ok().body(r);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> deleteStudent(@PathVariable Long id) {
        if (studentRepo.existsById(id)) {
            this.studentRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).build();
    }
}
