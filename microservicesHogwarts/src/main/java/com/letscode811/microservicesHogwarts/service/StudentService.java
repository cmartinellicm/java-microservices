package com.letscode811.microservicesHogwarts.service;

import com.letscode811.microservicesHogwarts.dto.StudentResponse;
import com.letscode811.microservicesHogwarts.entity.HouseKey;
import com.letscode811.microservicesHogwarts.entity.HouseName;
import com.letscode811.microservicesHogwarts.entity.Student;
import com.letscode811.microservicesHogwarts.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student create(Student student) {
        String uri = "https://api-harrypotter.herokuapp.com/sortinghat";
        RestTemplate restTemplate = new RestTemplate();
        HouseKey houseKey = restTemplate.getForObject(uri, HouseKey.class);

        student.setHouseKey(houseKey.getSortingHatChoice());

        return studentRepository.save(student);
    }

    public StudentResponse getById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();

        String uri = "https://api-harrypotter.herokuapp.com/house/" + student.getHouseKey();
        RestTemplate restTemplate = new RestTemplate();
        HouseName houseName = restTemplate.getForObject(uri, HouseName.class);

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setHouseName(houseName.getName());

        return studentResponse;
    }
}
