package com.jt.sms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.sms.entity.Student;
import com.jt.sms.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> gStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student newStudent) {
        return studentService.saveStudent(newStudent);
    }
}
