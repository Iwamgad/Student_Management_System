package com.dagmawi.StudentManagementSystem.service;

import com.dagmawi.StudentManagementSystem.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public Student saveStudent(Student student);
    public List<Student> getStudentList();
    public Student getStudentById(Long studentId);
}
