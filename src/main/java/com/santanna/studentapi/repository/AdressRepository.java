package com.santanna.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santanna.studentapi.domain.model.Adress;

public interface AdressRepository extends JpaRepository<Adress, Long> {

}
