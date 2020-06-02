package com.zeecoder.kidsart.controller;

import com.zeecoder.kidsart.model.Student;

import java.util.List;
import java.util.UUID;

import com.zeecoder.kidsart.model.StudentCourse;
import com.zeecoder.kidsart.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("students")
public class StudentController {

    private StudentServiceImpl studentServiceImpl;

    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }


  @GetMapping
  public List<Student> getAllStudents(){
    return studentServiceImpl.getAllStudents();
  }

  @GetMapping("{student_id}/courses")
  public List<StudentCourse> getAllCoursesForStudent(@PathVariable("student_id") UUID student_id){
    return studentServiceImpl.getAllCoursesForStudent(student_id);
  }

  @PostMapping
  public void addNewUsers(@RequestBody @Valid Student student){
        studentServiceImpl.addStudent(null, student);
  }
}
