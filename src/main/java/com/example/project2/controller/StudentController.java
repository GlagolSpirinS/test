package com.example.project2.controller;

import com.example.project2.model.StudentModel;
import com.example.project2.service.InMemoryStudentImpl;
import com.example.project2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getStudentAll(Model model){
        var students = studentService.findAllStudent();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/create")
    public String getCreateStudent() {
        return "createStudent";
    }

    @PostMapping("/create")
    public String postCreateStudent(
            @RequestParam(name="name") String name,
            @RequestParam(name="email") String email,
            @RequestParam(name="password") String password
    ) {
        studentService.createStudent(new StudentModel(name, email, password));
        return "redirect:/student";
    }
}

