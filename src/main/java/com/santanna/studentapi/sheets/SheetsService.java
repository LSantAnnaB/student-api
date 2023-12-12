package com.santanna.studentapi.sheets;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanna.studentapi.domain.model.Student;
import com.santanna.studentapi.repository.StudentRepository;

@Service
public class SheetsService {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired

  public ByteArrayInputStream getActualData() {
    List<Student> allStudents = studentRepository.findAll();

    ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(allStudents);
    return byteArrayInputStream;
  }
}
