package com.santanna.studentapi.domain.model;

import java.io.Serializable;

import com.santanna.studentapi.domain.dto.adress.AdressDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Adress implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String cep;

  private String logradouro;

  private String uf;

  private String bairro;

  public Adress(AdressDTO adressDTO) {
    this.cep = adressDTO.getCep();
    this.logradouro = adressDTO.getLogradouro();
    this.uf = adressDTO.getUf();
    this.bairro = adressDTO.getBairro();
  }
}
