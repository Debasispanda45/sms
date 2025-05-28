package com.jt.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
    // Additional query methods can be defined here if needed
    
}
