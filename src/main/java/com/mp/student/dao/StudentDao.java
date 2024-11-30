package com.mp.student.dao;

import com.mp.student.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

    List<Student> findAll();

    Student findStudentByStudentId(int id);

    Student findStudentByName(String name);

    @Transactional
    int deleteByNameAndSem(String name, String sem);


}
