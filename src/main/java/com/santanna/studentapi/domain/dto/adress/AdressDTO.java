package com.santanna.studentapi.domain.dto.adress;

import com.santanna.studentapi.domain.model.Adress;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdressDTO {

  private String cep;

  private String logradouro;
  private String localidade;

  private String numero;

  private String uf;

  private String bairro;

  private boolean erro;

  public AdressDTO(Adress adress) {
    this.cep = adress.getCep();
    this.logradouro = adress.getLogradouro();
    this.uf = adress.getUf();
    this.bairro = adress.getBairro();
    this.localidade = adress.getLocalidade();
    this.numero = adress.getNumero();
  }
}
