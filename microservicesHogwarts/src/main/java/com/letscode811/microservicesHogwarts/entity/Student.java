package com.letscode811.microservicesHogwarts.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "student")
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer grade;
    private String houseKey;
}
