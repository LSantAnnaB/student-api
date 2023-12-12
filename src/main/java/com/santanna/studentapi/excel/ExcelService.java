package com.santanna.studentapi.excel;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanna.studentapi.domain.model.Adress;
import com.santanna.studentapi.domain.model.Student;
import com.santanna.studentapi.repository.AdressRepository;
import com.santanna.studentapi.repository.StudentRepository;

@Service
public class ExcelService {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private  AdressRepository adressRepository;

  public ByteArrayInputStream getActualData() {
    List<Student> allStudents = studentRepository.findAll();

    List<Adress> allAddresses = adressRepository.findAll();

    ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(allStudents, allAddresses);
    return byteArrayInputStream;
  }
}
