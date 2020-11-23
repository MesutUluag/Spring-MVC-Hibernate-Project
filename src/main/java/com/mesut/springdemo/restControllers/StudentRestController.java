package com.mesut.springdemo.restControllers;

import com.mesut.springdemo.entity.Student;
import com.mesut.springdemo.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;

    @PostConstruct //called after spring initialization
    public void loadData(){
        students= new ArrayList<>();

        Student student= new Student();
        student.setFirstName("Mesut");
        student.setLastName("Uluag");

        Student student2= new Student();
        student2.setFirstName("Sinem");
        student2.setLastName("Uluag");

        students.add(student);
        students.add(student2);

    }

    @RequestMapping("/students")
    public List<Student> getAllStudents(){
        return students;
    }

    @RequestMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(students.size()<studentId||studentId<0){
            throw new StudentNotFoundException("Student Did Not Found " + studentId);
        }
        return students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add an exception handler to handle all exceptions - generic exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }
}
