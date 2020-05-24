package com.example.springboot.service;

import com.example.springboot.dao.ITeacherDao;
import com.example.springboot.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherService implements ITeacherService {

    @Autowired
    private ITeacherDao iTeacherDao;


    @Override
    public Teacher getById(Long id) {
        return iTeacherDao.getTeacherById(id);
    }

    @Override
    public Teacher getByName(String teacherFirstName, String teacherLastName) {
        return iTeacherDao.getTeacherByFirstNameAndLastName(teacherFirstName,
                teacherLastName);
    }

    @Override
    public Teacher getByCourseName(String courseName) {
        return iTeacherDao.getTeacherByCourseName(courseName);
    }

    @Override
    public void deleteById(Long id) {
        iTeacherDao.deleteById(id);
    }

    @Override
    public void save(Teacher teacher) {
        iTeacherDao.save(teacher);
    }
}
