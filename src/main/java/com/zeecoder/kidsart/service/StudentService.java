package com.zeecoder.kidsart.service;

import com.zeecoder.kidsart.model.Student;
import com.zeecoder.kidsart.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents(){
     return studentDAO.selectAllStudents();
    }

    public void addStudent(UUID student_id, Student student) {
        UUID uuid = Optional.ofNullable(student_id).orElse(UUID.randomUUID());
        studentDAO.addStudent(uuid, student);
    }
}
