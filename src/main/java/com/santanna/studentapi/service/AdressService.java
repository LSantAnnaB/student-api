package com.santanna.studentapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.santanna.studentapi.domain.dto.adress.AdressDTO;

@Service
public class AdressService {
  private final WebClient webClient;

  public AdressService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://viacep.com.br").build();
  }

  public AdressDTO adressQuery(String cep) {
    try {
      AdressDTO adress = webClient.get()
          .uri("/ws/{cep}/json/", cep)
          .retrieve()
          .bodyToMono(AdressDTO.class)
          .block();

      return adress;

    } catch (WebClientResponseException e) {
      // Log a exceção para registro detalhado
      System.out.println(e.getMessage());
      throw e;
    }
  }

}
