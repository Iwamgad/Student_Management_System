package com.dagmawi.StudentManagementSystem;

import com.dagmawi.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @Autowired
    public StudentService studentService;

    @GetMapping("/")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getStudentList());
        return "index";
    }
}



