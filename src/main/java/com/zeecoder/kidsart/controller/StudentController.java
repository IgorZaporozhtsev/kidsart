package com.zeecoder.kidsart.controller;

import com.zeecoder.kidsart.model.Student;
import com.zeecoder.kidsart.model.Student.Gender;
import java.util.List;
import java.util.UUID;

import com.zeecoder.kidsart.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


  @GetMapping
  public List<Student> getAllStudents(){
    return studentService.getAllStudents();
  }

  @PostMapping
  public void addNewUsers(@RequestBody @Valid Student student){
        studentService.addStudent(null, student);
  }
}
