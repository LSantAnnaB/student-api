package com.santanna.studentapi.domain.dto.student;

import com.santanna.studentapi.domain.dto.adress.AdressDTO;
import com.santanna.studentapi.domain.model.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {

  private String name;
  private String email;
  private String phone;
  private String course;
  private String cpf;
  private AdressDTO adressDTO;

  public StudentDTO(Student student) {
    name = student.getName();
    email = student.getEmail();
    phone = student.getPhone();
    course = student.getCourse();
    cpf = student.getCpf();
    adressDTO = new AdressDTO(student.getAdress());
  }
}
