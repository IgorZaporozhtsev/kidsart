package com.zeecoder.kidsart.controller;

import com.zeecoder.kidsart.model.Student;
import com.zeecoder.kidsart.model.Student.Gender;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {

  @GetMapping
  public List<Student> getAllStudents(){
    return List.of(
          new Student(UUID.randomUUID(), "Jameson", "Bond", "jamesbons@gmail.com", Student.Gender.MALE),
          new Student(UUID.randomUUID(), "Elisa", "Tamara", "elisatamara@gmail.com", Gender.FEMALE)
        );
  }
}
