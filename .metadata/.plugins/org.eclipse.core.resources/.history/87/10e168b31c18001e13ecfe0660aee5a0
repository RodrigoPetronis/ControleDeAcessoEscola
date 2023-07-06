package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping
@AllArgsConstructor
public class AlunoController {
	
	@Autowired  					//Instantiate automatically all values from AlunoRepository
	private AlunoRepository alunoRepository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/alunos")   					//Using Method HTTP Get
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}
									//Using Method HTTP Get to search by Id
	@GetMapping("/alunos/{id}")
	public Optional<Aluno> getAlunosById(@PathVariable Long id){
		return alunoRepository.findById(id);
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/alunos/matricula/{matricula}")
	public Aluno getAlunosByMatricula(@PathVariable Long matricula){
		return alunoRepository.findByMatricula(matricula);
	}
	
	@PostMapping("/alunos")					//Using Method HTTP Post
	@ResponseStatus (HttpStatus.CREATED)
	public Aluno addAluno(@RequestBody @Valid Aluno aluno) {  //@RequestBody convert Json to Aluno type
		return alunoRepository.save(aluno);
	}
									//Using Method HTTP Delete to remove by Id
	@DeleteMapping("/alunos/{id}")
	public void removeAluno(@PathVariable Long id){
		alunoRepository.deleteById(id);
	}
	
	@PutMapping("/alunos/{id}")
	public Aluno updateAluno(@PathVariable Long id,@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
}
