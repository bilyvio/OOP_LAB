package com.example.springboot.dao;

import com.example.springboot.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITeacherDao extends JpaRepository<Teacher,Long> {

    Teacher getTeacherById (Long id);
    Teacher getTeacherByFirstNameAndLastName (String teacherFirstName, String teacherLastName);
    Teacher getTeacherByCourseName (String courseName);


}
