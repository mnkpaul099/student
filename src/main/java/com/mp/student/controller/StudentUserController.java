package com.mp.student.controller;

import com.mp.student.entity.StudentDetails;
import com.mp.student.service.StudentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-v1")
public class StudentUserController {

    @Autowired
    StudentUserService studentUserService;

    @PostMapping("/register")
    public StudentDetails register(@RequestBody StudentDetails studentDetails){
        return studentUserService.register(studentDetails);
    }

    @PostMapping("/login")
    public String login(@RequestBody StudentDetails studentDetails){
        return studentUserService.verify(studentDetails);
    }
}
