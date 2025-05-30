package com.jt.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jt.sms.entity.Student;
import com.jt.sms.exception.StudentNotFoundException;
import com.jt.sms.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    
    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student saveStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public void deleteStudentById(String id) {
        var existingStudent = getStudentById(id);
        studentRepository.delete(existingStudent);
    }

    public Student updateStudentById(String StudentId, Student student) {
        student.setStudentid(StudentId);
        return studentRepository.save(student);

        
    }
    
}
