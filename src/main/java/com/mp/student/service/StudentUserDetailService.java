package com.mp.student.service;

import com.mp.student.dao.StudentDetailsDao;
import com.mp.student.entity.StudentDetails;
import com.mp.student.entity.StudentUserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentUserDetailService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(StudentUserDetailService.class);

    @Autowired
    private StudentDetailsDao studentDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        StudentDetails studentDetails = studentDetailsDao.findByUsername(username);
        if(studentDetails == null) {
            logger.info("StudentUser not found");
            throw new UsernameNotFoundException("StudentUser not found");
        }
        return new StudentUserPrincipal(studentDetails);
    }
}
