package com.santanna.studentapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanna.studentapi.domain.dto.student.StudentDTO;
import com.santanna.studentapi.domain.dto.student.StudentInsertDTO;
import com.santanna.studentapi.domain.model.Student;
import com.santanna.studentapi.exception.UserNotFoundException;
import com.santanna.studentapi.repository.StudentRepository;

@Service
public class StudentService {

  @Autowired
  private StudentRepository sRepository;

  public StudentDTO addStudent(StudentInsertDTO studentInsertDTO) {
    Student student = new Student(studentInsertDTO);
    student.setStudentCode(UUID.randomUUID().toString());
    Student studentPersisted = sRepository.save(student);
    return new StudentDTO(studentPersisted);
  }

  public StudentDTO findStudentById(Long id) {
    Student student = sRepository.findStudentById(id)
        .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    return new StudentDTO(student);
  }

  public List<Student> findAllStudents() {
    return sRepository.findAll();
  }

  public StudentDTO updateStudent(StudentDTO studentDTO) {
    Long id = studentDTO.getId();
    Optional<Student> studentOptional = sRepository.findById(id);

    if (studentOptional.isPresent()) {
      Student existingStudent = studentOptional.get();

      existingStudent.setName(studentDTO.getName());
      existingStudent.setShift(studentDTO.getShift());
      existingStudent.setPhone(studentDTO.getPhone());
      existingStudent.setData(studentDTO.getData());
      existingStudent.setPrice(studentDTO.getPrice());
      existingStudent.setResponsible(studentDTO.getResponsible());

      Student updatedStudent = sRepository.save(existingStudent);
      return new StudentDTO(updatedStudent);
    } else {
      throw new UserNotFoundException("User by id " + id + " was not found");
    }
  }

  public StudentDTO deleteStudent(Long id) {
    Optional<Student> studentOptional = sRepository.findById(id);

    if (studentOptional.isPresent()) {
      Student student = studentOptional.get();
      sRepository.deleteById(id);
      return new StudentDTO(student);
    } else {
      throw new UserNotFoundException("User by id " + id + " was not found");
    }
  }
}
