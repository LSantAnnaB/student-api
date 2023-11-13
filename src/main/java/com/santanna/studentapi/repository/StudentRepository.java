package com.santanna.studentapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santanna.studentapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

  void deleteStudentById(Long id);

  Optional<Student> findStudentById(Long id);

}
