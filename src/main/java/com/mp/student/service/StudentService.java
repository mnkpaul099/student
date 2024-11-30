package com.mp.student.service;

import com.mp.student.dto.StudentDto;
import com.mp.student.entity.Student;
import com.mp.student.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    List<Student> searchAllStudentService();

    Student searchStudentService(int id) throws StudentNotFoundException;

    Student addStudentService(StudentDto employeeDto);

    Student updateStudentService(StudentDto studentDto) throws StudentNotFoundException;

    String deleteStudentService(int id) throws StudentNotFoundException;

    List<Student> fetchStudentsService();
}
