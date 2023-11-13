package com.santanna.studentapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santanna.studentapi.model.Student;
import com.santanna.studentapi.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentService service;

  @GetMapping("/all")
  public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> students = service.findAllStudents();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
    Student student = service.findStudentById(id);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
    service.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Student> addStudents(@RequestBody Student student) {
    Student addStudent = service.addStudent(student);
    return new ResponseEntity<>(addStudent, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Student> updateStudents(@RequestBody Student student) {
    Student updateStudent = service.updateStudent(student);
    return new ResponseEntity<>(updateStudent, HttpStatus.OK);
  }

}
