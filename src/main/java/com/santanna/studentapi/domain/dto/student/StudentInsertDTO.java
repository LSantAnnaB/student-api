package com.santanna.studentapi.domain.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentInsertDTO {
  private String name;
  private String shift;
  private String phone;
  private String data;
  private String contractTime;
  private String price;
  private String responsible;
}
