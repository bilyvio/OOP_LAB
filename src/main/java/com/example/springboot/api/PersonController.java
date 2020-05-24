package com.example.springboot.api;

import com.example.springboot.ConfigurationClass;
import com.example.springboot.model.Person;
import com.example.springboot.model.Teacher;
import com.example.springboot.service.IPersonService;
import com.example.springboot.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/person")
@Controller
public class  PersonController {

    @Autowired
    private IPersonService personService;

    @Autowired
    private ITeacherService teacherService;



    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);

    @GetMapping("/getAllPeople")
    @ResponseBody
    public Iterable<Person> getAllPeople () {
        return personService.findAll();
    }

    @GetMapping("/getAllPeopleByGender")
    @ResponseBody
    public Iterable<Person> getAllPeopleByGender (@RequestParam("gender") String gender) { return personService.findAllByGender(gender); }

    @GetMapping("/getAllPeopleByCourseName")
    @ResponseBody
    public Iterable<Person> getAllPeopleByCourseName (@RequestParam("courseName") String courseName) { return personService.findAllByCourseName(courseName); }

    @GetMapping(path = "/person/{id}")
    @ResponseBody
    public Person getPersonById(@PathVariable("id") Long id) {
        return personService.findById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "/person/{id}")
    public void deletePersonById(@PathVariable("id") Long id) {
        personService.deleteById(id);

    }

    @PostMapping("/updateOrCreateUser")
    public void updatePerson(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("teacherName") String teacherName,
                             @RequestParam("courseName") String courseName,
                             @RequestParam("gender") String gender,
                             @RequestParam("grade") Integer grade) {
        Person person = (Person) applicationContext.getBean("person");
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setTeacherName(teacherName);
        person.setCourseName(courseName);
        person.setGender(gender);
        person.setGrade(grade);
        personService.save(person);
    }

    @GetMapping(path = "/personByFirstNameAndLastName")
    @ResponseBody
    public Person getPersonByFirstAndLastName (@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName) {
        return personService.getPersonByFirstAndLastName(firstName,lastName);
    }

    @GetMapping(path = "/teacher/{id}")
    @ResponseBody
    public Teacher getTeacherById (@PathVariable Long id) {
        return teacherService.getById(id);
    }

    @GetMapping("/teacherByCourseName")
    @ResponseBody
    public Teacher getTeacherByCourseName (@RequestParam("courseName") String courseName) {
        return teacherService.getByCourseName(courseName);
    }

    @DeleteMapping(path = "/teacher/{id}")
    public void deleteTeacherById(@PathVariable("id") Long id) {
        teacherService.deleteById(id);
    }

    @PostMapping("/updateOrCreateTeacher")
    public void updateTeacher(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("teacherUserName") String teacherUserName,
                              @RequestParam("teacherName") String teacherName,
                              @RequestParam("courseName") String courseName) {
        Teacher teacher = (Teacher) applicationContext.getBean("teacher");
        teacher.setTeacherName(firstName);
        teacher.setTeacherName(lastName);
        teacher.setTeacherUserName(teacherUserName);
        teacher.setTeacherName(teacherName);
        teacher.setCourseName(courseName);
        teacherService.save(teacher);
    }
}
