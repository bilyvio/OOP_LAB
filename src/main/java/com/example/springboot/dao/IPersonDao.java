package com.example.springboot.dao;

import com.example.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonDao extends JpaRepository<Person,Long> {

    List<Person> findAllByGender(String gender);
    List<Person> findAllByCourseName(String courseName);
    Person getPersonByFirstNameAndLastName (String firstName, String lastName);


}
