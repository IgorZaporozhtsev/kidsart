package com.zeecoder.kidsart.repository;

import com.zeecoder.kidsart.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class StudentDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> selectAllStudents(){
        String sql = "SELECT student_id, first_name, last_name, email, gender FROM student";
        return jdbcTemplate.query(sql, mapStudentFromDb());
    }

    public int addStudent(UUID uuid, Student student) {
        String sql = "INSERT INTO student (student_id, first_name, last_name, email, gender) VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                uuid,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getGender().name().toUpperCase()
        );
    }

    public boolean isEmailTaken(String email){

        String sql = "SELECT EXISTS (SELECT 1 FROM student WHERE email = ?)";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[] {email},
                (resultSet, rowNum) -> resultSet.getBoolean(1)
        );
    }

    private RowMapper<Student> mapStudentFromDb() {
        return (resultSet, rowNum) -> {
            String studentIDStr = resultSet.getString("student_id");
            UUID studentId= UUID.fromString(studentIDStr);

            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String genderStr = resultSet.getString("gender").toUpperCase();
            Student.Gender gender = Student.Gender.valueOf(genderStr);
            return new Student(studentId, firstName,lastName,email, gender);
        };
    }

}
