package com.letscode811.microservicesHogwarts.controller;

import com.letscode811.microservicesHogwarts.dto.StudentResponse;
import com.letscode811.microservicesHogwarts.entity.Student;
import com.letscode811.microservicesHogwarts.repository.StudentRepository;
import com.letscode811.microservicesHogwarts.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponse getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        studentRepository.delete(student);
    }
}
