package com.lrd.webspringthymeleaf.repositories;

import com.lrd.webspringthymeleaf.entities.Professeur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProfesseurRepository extends JpaRepository<Professeur, Integer> {
    Optional<Professeur> findByEmail(String email);
}
