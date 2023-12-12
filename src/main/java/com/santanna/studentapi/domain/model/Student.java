package com.santanna.studentapi.domain.model;

import java.io.Serializable;

import com.santanna.studentapi.domain.dto.student.StudentInsertDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Student implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;
  private String name;
  private String shift;
  private String phone;
  private String data;
  private String contractTime;
  private String price;
  private String responsible;
  @Column(nullable = false, updatable = false)
  private String studentCode;

  public Student(StudentInsertDTO studentInsertDTO) {
    this.name = studentInsertDTO.getName();
    this.shift = studentInsertDTO.getShift();
    this.phone = studentInsertDTO.getPhone();
    this.data = studentInsertDTO.getData();
    this.contractTime = studentInsertDTO.getContractTime();
    this.price = studentInsertDTO.getPrice();
    this.responsible = studentInsertDTO.getResponsible();

  }
}
