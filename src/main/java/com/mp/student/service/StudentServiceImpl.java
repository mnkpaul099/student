package com.mp.student.service;

import com.mp.student.dao.StudentDao;
import com.mp.student.dto.StudentDto;
import com.mp.student.entity.Student;
import com.mp.student.exception.StudentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mp.student.common.StudentConstants.METHOD_NAME;

@Service
public class StudentServiceImpl implements StudentService{

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> searchAllStudentService() {
        logger.info(METHOD_NAME, "searchAllStudentService");
        return studentDao.findAll();
    }

    @Override
    public Student searchStudentService(int id) throws StudentNotFoundException {
        logger.info(METHOD_NAME, "searchStudentService");
        Student student = studentDao.findStudentByStudentId(id);
        if(student.toString().isEmpty()){
            logger.info("StudentId = {} not found", id);
            throw new StudentNotFoundException("StudentId = " + id + " not found");
        }
        return student;
    }

    @Override
    public Student addStudentService(StudentDto studentDto) {
        logger.info(METHOD_NAME, "addStudentService");
        Student student = Student.build(studentDto.getStudentId(), studentDto.getName(), studentDto.getDepartment(), studentDto.getSem());
        return studentDao.save(student);
    }

    @Override
    public Student updateStudentService(StudentDto studentDto) throws StudentNotFoundException {
        logger.info(METHOD_NAME, "updateStudentService");
        Student student = Student.build(studentDto.getStudentId(), studentDto.getName(), studentDto.getDepartment(), studentDto.getSem());
        if (studentDao.findStudentByStudentId(student.getStudentId()) != null) {
            logger.info("update StudentId = {}", studentDto.getStudentId());
            return studentDao.save(student);
        } else {
            throw new StudentNotFoundException("student not found with studentId = " + studentDto.getStudentId());
        }
    }

    @Override
    public String deleteStudentService(int id) throws StudentNotFoundException {
        logger.info(METHOD_NAME, "deleteStudentService");
        if (studentDao.findStudentByStudentId(id) != null) {
            logger.info("delete studentId = {}", id);
            studentDao.deleteById(id);
            return "studentId = " + id + " details deleted";
        } else {
            throw new StudentNotFoundException("No student with studentId = " + id);
        }
    }

    @Override
    public List<Student> fetchStudentsService() {
        logger.info(METHOD_NAME, "fetchStudentsService");
        return studentDao.findAll();
    }
}
