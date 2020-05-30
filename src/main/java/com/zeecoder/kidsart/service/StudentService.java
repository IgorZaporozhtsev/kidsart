package com.zeecoder.kidsart.service;

import com.zeecoder.kidsart.EmailValidator;
import com.zeecoder.kidsart.exception.ApiRequestException;
import com.zeecoder.kidsart.model.Student;
import com.zeecoder.kidsart.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDAO studentDAO;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(StudentDAO studentDAO, EmailValidator emailValidator) {
        this.studentDAO = studentDAO;
        this.emailValidator = emailValidator;
    }

    public List<Student> getAllStudents(){
     return studentDAO.selectAllStudents();
    }

    public void addStudent(UUID student_id, Student student) {
        UUID uuid = Optional.ofNullable(student_id).orElse(UUID.randomUUID());

        if (!emailValidator.test(student.getEmail())){
           throw new ApiRequestException(student.getEmail() + " is not valid");
        }

        if (studentDAO.isEmailTaken(student.getEmail())){
            throw new ApiRequestException(student.getEmail() + " already exist");
        }

        studentDAO.addStudent(uuid, student);
    }
}
