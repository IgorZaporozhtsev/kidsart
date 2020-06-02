package com.zeecoder.kidsart.model;

import java.time.LocalDate;
import java.util.UUID;

public class StudentCourse {
    private final UUID student_id;
    private final UUID course_id;
    private final String name;
    private final String description;
    private final String department;
    private final String teacherName;
    private final LocalDate start_date; 
    private final LocalDate end_date;
    private final int grade;

    public StudentCourse(UUID student_id,
                         UUID course_id,
                         String name,
                         String description,
                         String department,
                         String teacherName,
                         LocalDate start_date,
                         LocalDate end_date,
                         int grade) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.name = name;
        this.description = description;
        this.department = department;
        this.teacherName = teacherName;
        this.start_date = start_date;
        this.end_date = end_date;
        this.grade = grade;
    }

    public UUID getStudent_id() {
        return student_id;
    }

    public UUID getCourse_id() {
        return course_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartment() {
        return department;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public int getGrade() {
        return grade;
    }
}
