package com.santanna.studentapi.domain.model;

import java.io.Serializable;

import com.santanna.studentapi.domain.dto.adress.AdressDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Adress implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String cep;

  private String logradouro;

  private String localidade;

  private String numero;

  private String uf;

  private String bairro;

  public Adress(AdressDTO adressDTO) {
    this.cep = adressDTO.getCep();
    this.logradouro = adressDTO.getLogradouro();
    this.uf = adressDTO.getUf();
    this.bairro = adressDTO.getBairro();
    this.localidade = adressDTO.getLocalidade();
    this.numero = adressDTO.getNumero();
  }
}
