package com.dagmawi.StudentManagementSystem.controller;

import com.dagmawi.StudentManagementSystem.entity.Student;
import com.dagmawi.StudentManagementSystem.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Logger

    private final Logger LOGGER = LoggerFactory.getLogger(Student.class);

    // Saves students to the database

    @PostMapping()
    public Student saveStudent(@Valid @RequestBody Student student){
        LOGGER.info("Inside saveStudent of Student Controller ");
        return studentService.saveStudent(student);
    }

    // Gets all the students from the database

    @GetMapping()
    public List<Student> getStudentList(){
        LOGGER.info("Inside getStudentList of Student Controller ");
        return studentService.getStudentList();
    }

    // Gets a student by ID

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId) {
        LOGGER.info("Inside getStudentById of Student Controller ");
        return studentService.getStudentById(studentId);
    }

    // Lists students on the html

    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getStudentList());
        return "students";
    }

    // Deletes a student by ID

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId){
        LOGGER.info("Inside deleteStudentById of Student Controller ");
        studentService.deleteStudentById(studentId);
        return "Student deleted successfully !!!";
    }

    // Updates a student by Id

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable("id") Long studentId,
                                     @RequestBody Student student){
        LOGGER.info("Inside updateStudentById of Student Controller ");
        return studentService.updateStudentById(studentId, student);
    }


}
