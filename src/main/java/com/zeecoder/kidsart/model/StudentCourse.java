package com.zeecoder.kidsart.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class StudentCourse {
    private final UUID student_id;
    private final UUID course_id;
    private final String name;
    private final String description;
    private final String department;
    private final String teacherName;
    private final LocalDate start_date;
    private final LocalDate end_date;
    private final Integer grade;

    public StudentCourse(UUID student_id,
                         UUID course_id,
                         String name,
                         String description,
                         String department,
                         String teacherName,
                         LocalDate start_date,
                         LocalDate end_date,
                         Integer grade) {
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
}
