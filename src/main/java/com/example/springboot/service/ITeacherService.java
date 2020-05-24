package com.example.springboot.service;

import com.example.springboot.model.Person;
import com.example.springboot.model.Teacher;

import java.util.Optional;

public interface ITeacherService {

    Teacher getById (Long id);
    Teacher getByName (String teacherFirstName, String teacherLastName);
    Teacher getByCourseName (String courseName);
    void deleteById (Long id);
    void save(Teacher teacher);

}
