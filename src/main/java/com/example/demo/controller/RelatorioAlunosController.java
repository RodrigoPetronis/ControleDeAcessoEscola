package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RelatorioAlunos;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.RelatorioAlunosRepository;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping
public class RelatorioAlunosController {

	@Autowired
	public RelatorioAlunosRepository repository;
	public AlunoRepository alunoRepository;
	
	
	public RelatorioAlunosController(RelatorioAlunosRepository repository, AlunoRepository alunoRepository) {
		super();
		this.repository = repository;
		this.alunoRepository = alunoRepository;
	}


	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/relatorios/alunos")   					//Using Method HTTP Get
	public List<RelatorioAlunos> getAllAlunos() {
		return repository.findAll();
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/relatorios/alunos")
	//public RelatorioAlunos addAcessoPorMatricula(@RequestBody RelatorioAlunos matricula, RelatorioAlunos nomeCompleto, RelatorioAlunos cpf) {
		//return repository.save(matricula, nomeCompleto, cpf);
		
	public ResponseEntity<RelatorioAlunos> addAcessoPorMatricula(@RequestBody RelatorioAlunos relatorioAlunos){
		
		return ResponseEntity.ok(repository.save(relatorioAlunos));
		
		}
	}






