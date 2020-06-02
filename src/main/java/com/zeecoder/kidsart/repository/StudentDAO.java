package com.zeecoder.kidsart.repository;

import com.zeecoder.kidsart.model.Student;
import com.zeecoder.kidsart.model.StudentCourse;

import java.util.List;
import java.util.UUID;

public interface StudentDAO {
    List<Student> selectAllStudents();
    int insertStudent(UUID uuid, Student student);
    List<StudentCourse> fetchAllCoursesForStudent(UUID student_id);
    boolean isEmailTaken(String email);
}
