package com.santanna.studentapi.domain.model;

import java.io.Serializable;

import com.santanna.studentapi.domain.dto.student.StudentInsertDTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Student implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;
  @NotBlank(message = "Student NAME is required")
  @Size(min = 10, max = 100)
  private String name;
  @Size(min = 10, max = 1000)
  @NotBlank(message = "Student E-MAIL is required")
  private String email;
  private String phone;
  private String course;
  private String cpf;
  @Column(nullable = false, updatable = false)
  private String studentCode;

  @Embedded
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Adress adress;

  public Student(StudentInsertDTO studentInsertDTO) {
    this.name = studentInsertDTO.getName();
    this.email = studentInsertDTO.getEmail();
    this.phone = studentInsertDTO.getPhone();
    this.course = studentInsertDTO.getCourse();
    this.cpf = studentInsertDTO.getCpf();

  }
}
