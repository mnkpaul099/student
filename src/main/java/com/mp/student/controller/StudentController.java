package com.mp.student.controller;

import com.mp.student.dto.StudentDto;
import com.mp.student.entity.Student;
import com.mp.student.exception.StudentNotFoundException;
import com.mp.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.mp.student.common.StudentConstants.METHOD_NAME;

@Controller
@RequestMapping("/student-v1")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public  ResponseEntity<List<Student>> fetchStudents() {
        logger.info(METHOD_NAME, "fetchStudents");
        return ResponseEntity.ok(studentService.fetchStudentsService());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> searchStudent(@PathVariable int id) throws StudentNotFoundException {
        logger.info(METHOD_NAME, "searchStudent");
        logger.info("StudentId = {}", id);
        return ResponseEntity.ok(studentService.searchStudentService(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto) {
        logger.info(METHOD_NAME, "addStudent");
        return new ResponseEntity<>(studentService.addStudentService(studentDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody StudentDto studentDto) throws StudentNotFoundException {
        logger.info(METHOD_NAME, "updateStudent");
        if(studentService.updateStudentService(studentDto) != null)
            return new ResponseEntity<>(studentService.updateStudentService(studentDto), HttpStatus.CREATED);
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) throws StudentNotFoundException {
        return new ResponseEntity<>(studentService.deleteStudentService(id), HttpStatus.ACCEPTED);
    }

}
