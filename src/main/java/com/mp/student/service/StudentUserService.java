package com.mp.student.service;

import com.mp.student.dao.StudentDetailsDao;
import com.mp.student.entity.StudentDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentUserService {

    Logger logger = LoggerFactory.getLogger(StudentUserService.class);

    @Autowired
    StudentDetailsDao studentDetailsDao;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);

    public StudentDetails register(StudentDetails studentDetails) {
        studentDetails.setPassword(encoder.encode(studentDetails.getPassword()));
        return studentDetailsDao.save(studentDetails);
    }

    public String verify(StudentDetails studentDetails) {
        logger.info("verify");
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(studentDetails.getUsername(), studentDetails.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(studentDetails.getUsername());
        }
        return "failure";
    }
}
