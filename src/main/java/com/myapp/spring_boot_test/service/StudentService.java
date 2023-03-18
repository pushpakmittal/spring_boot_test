package com.myapp.spring_boot_test.service;

import com.myapp.spring_boot_test.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student addStudent(Student student) {
        return student;
    }
}
