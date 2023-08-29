package com.dagmawi.StudentManagementSystem.service;

import com.dagmawi.StudentManagementSystem.entity.Student;
import com.dagmawi.StudentManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.get();
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudentById(Long studentId, Student student) {

        Student studentDB = studentRepository.findById(studentId).get();

        if(Objects.nonNull(student.getFirstName()) &&
                !"".equalsIgnoreCase(student.getFirstName())){
            studentDB.setFirstName(student.getFirstName());
        }

        if(Objects.nonNull(student.getLastName()) &&
                !"".equalsIgnoreCase(student.getLastName())){
            studentDB.setLastName(student.getLastName());
        }

        if(Objects.nonNull(student.getEmail()) &&
                !"".equalsIgnoreCase(student.getEmail())){
            studentDB.setEmail(student.getEmail());
        }

        return studentRepository.save(studentDB);
    }

}
