package com.letscode811.microservicesHogwarts.dto;

import com.letscode811.microservicesHogwarts.entity.Student;
import lombok.Data;

@Data
public class StudentResponse {
    private Long id;
    private String name;
    private Integer grade;
    private String houseKey;
    private String houseName;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.grade = student.getGrade();
        this.houseKey = student.getHouseKey();
    }
}
