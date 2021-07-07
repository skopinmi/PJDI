package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.entities.Student;
import ru.geekbrains.repositories.StudentRepository;

@Controller
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public String getAll( Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "student";
    }

    @GetMapping("/student/delete/{id}")
    public String delete( Model model, @PathVariable("id") Long id) {
        studentRepository.deleteById(id);
        model.addAttribute("students", studentRepository.findAll());
        return "student";
    }

    @GetMapping("/student/new")
    public String getOne( Model model)   {
        model.addAttribute("student", new Student());
        return "student_form";
    }

    @GetMapping("/student/{id}")
    public String getOne( Model model, @PathVariable("id") Long id)   {
        model.addAttribute("student", studentRepository.findById(id).get());
        return "student_form";
    }

    @PostMapping("/student")
    public String postAll( Model model, Student student) {
        studentRepository.save(student);
        model.addAttribute("students", studentRepository.findAll());
        return "student";
    }
}
