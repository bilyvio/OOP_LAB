package com.example.springboot.service;

import com.example.springboot.dao.IPersonDao;
import com.example.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonDao iPersonDao;

    @Override
    public void save(Person person) {
        iPersonDao.save(person);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return iPersonDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        iPersonDao.deleteById(id);
    }

    @Override
    public Iterable<Person> findAll() {
        return iPersonDao.findAll();
    }

    @Override
    public Iterable<Person> findAllByGender(String gender) {
        return iPersonDao.findAllByGender(gender);
    }

    @Override
    public Iterable<Person> findAllByCourseName(String courseName) {
        return iPersonDao.findAllByCourseName(courseName);
    }

    @Override
    public Person getPersonByFirstAndLastName(String firstName, String lastName) {
        return iPersonDao.getPersonByFirstNameAndLastName(firstName, lastName);
    }


}
