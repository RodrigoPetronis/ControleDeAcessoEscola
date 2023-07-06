package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Aluno;
import com.example.demo.model.RelatorioAlunos;

public interface RelatorioAlunosRepository extends JpaRepository <RelatorioAlunos,Long> {

	RelatorioAlunos save(Aluno matricula);

	
}
