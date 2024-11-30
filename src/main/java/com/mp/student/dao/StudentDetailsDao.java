package com.mp.student.dao;

import com.mp.student.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailsDao extends JpaRepository<StudentDetails, Integer> {
    StudentDetails findByUsername(String username);
}
