package com.zeecoder.kidsart.repository;

import com.zeecoder.kidsart.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
        String sql = "";
        List<Student> students = jdbcTemplate.query(sql, (resultSet, i ) -> {
            return null;
        });
            return null;
    }
}
