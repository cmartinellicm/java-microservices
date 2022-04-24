package com.letscode811.microservicesHogwarts.repository;

import com.letscode811.microservicesHogwarts.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
