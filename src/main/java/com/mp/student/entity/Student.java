package com.mp.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Student {
    @Id
    private int studentId;
    private String name;
    private String department;
    private String sem;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", sem='" + sem + '\'' +
                '}';
    }
}
