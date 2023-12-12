package com.santanna.studentapi.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santanna.studentapi.domain.dto.student.StudentDTO;
import com.santanna.studentapi.domain.dto.student.StudentInsertDTO;
import com.santanna.studentapi.domain.model.Student;
import com.santanna.studentapi.service.StudentService;
import com.santanna.studentapi.sheets.SheetsService;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentService service;

  @Autowired
  private SheetsService sheetsService;

  @GetMapping("/all")
  public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> students = service.findAllStudents();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") Long id) {
    StudentDTO studentDTO = service.findStudentById(id);
    return new ResponseEntity<>(studentDTO, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<StudentDTO> deleteStudent(@PathVariable("id") Long id) {
    StudentDTO deletedStudentDTO = service.deleteStudent(id);
    return new ResponseEntity<>(deletedStudentDTO, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<StudentDTO> addStudents(@RequestBody StudentInsertDTO studentInsertDTO) {
    StudentDTO addStudent = service.addStudent(studentInsertDTO);
    return new ResponseEntity<>(addStudent, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<StudentDTO> updateStudents(@RequestBody StudentDTO studentDTO) {
    StudentDTO updatedStudentDTO = service.updateStudent(studentDTO);
    return new ResponseEntity<>(updatedStudentDTO, HttpStatus.OK);
  }

  @RequestMapping("/excel")
  public ResponseEntity<Resource> download() {
    String fileName = "students.xlsx";
    ByteArrayInputStream actualData = sheetsService.getActualData();
    InputStreamResource file = new InputStreamResource(actualData);
    ResponseEntity<Resource> body = ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
        .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
    return body;
  }
}
