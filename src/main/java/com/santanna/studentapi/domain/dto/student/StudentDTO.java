package com.santanna.studentapi.domain.dto.student;

import com.santanna.studentapi.domain.model.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {
  private Long id;
  private String name;
  private String shift;
  private String phone;
  private String data;
  private String contractTime;
  private String price;
  private String responsible;

  public StudentDTO(Student student) {
    name = student.getName();
    shift = student.getShift();
    phone = student.getPhone();
    data = student.getData();
    contractTime = student.getContractTime();
    price = student.getPrice();
    responsible = student.getResponsible();
  }
}
