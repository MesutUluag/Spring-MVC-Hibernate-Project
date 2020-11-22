package com.mesut.springdemo.restControllers;

import com.mesut.springdemo.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @RequestMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students= new ArrayList<>();

        Student student= new Student();
        student.setFirstName("Mesut");
        student.setLastName("Uluag");

        Student student2= new Student();
        student2.setFirstName("Sinem");
        student2.setLastName("Uluag");

        students.add(student);
        students.add(student2);

        return students;
    }
}
