package com.mp.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student-auth")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentDetails {
    @Id
    private int roleId;
    private String username;
    private String password;
}
