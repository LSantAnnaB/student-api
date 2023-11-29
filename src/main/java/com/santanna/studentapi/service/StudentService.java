package com.santanna.studentapi.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanna.studentapi.domain.dto.adress.AdressDTO;
import com.santanna.studentapi.domain.dto.student.StudentDTO;
import com.santanna.studentapi.domain.dto.student.StudentInsertDTO;
import com.santanna.studentapi.domain.model.Adress;
import com.santanna.studentapi.domain.model.Student;
import com.santanna.studentapi.exception.UserNotFoundException;
import com.santanna.studentapi.repository.StudentRepository;

@Service
public class StudentService {

  @Autowired
  private StudentRepository sRepository;

  public StudentDTO addStudent(StudentInsertDTO studentInsertDTO, AdressDTO adressDTO) {
    Student student = new Student(studentInsertDTO);
    Adress adress = new Adress(adressDTO);
    student.setAdress(adress);
    student.setStudentCode(UUID.randomUUID().toString());
    Student studentPersisted = sRepository.save(student);
    return new StudentDTO(studentPersisted);
  }

  public Student findStudentById(Long id) {
    return sRepository.findStudentById(id)
        .orElseThrow(() -> new UserNotFoundException("User by id" + id + " was not found "));
  }

  public List<Student> findAllStudents() {
    return sRepository.findAll();
  }

  public Student updateStudent(Student student) {
    return sRepository.save(student);
  }

  public void deleteStudent(Long id) {
    sRepository.deleteById(id);
  }
}