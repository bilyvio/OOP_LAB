package com.example.springboot.service;

import com.example.springboot.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService  {
    void save(Person person);
    Optional<Person> findById(Long id);
    void deleteById(Long id);
    Iterable<Person> findAll();
    Iterable<Person> findAllByGender (String gender);
    Iterable<Person> findAllByCourseName (String courseName);
    Person getPersonByFirstAndLastName (String firstName, String lastName);


}
