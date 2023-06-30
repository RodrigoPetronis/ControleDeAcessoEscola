package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Visitante;

public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

}
