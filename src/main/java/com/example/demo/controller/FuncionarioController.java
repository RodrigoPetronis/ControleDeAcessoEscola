package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping
@AllArgsConstructor
public class FuncionarioController {
	
	@Autowired  
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/funcionarios")
	public List<Funcionario> getAllFuncionarios(){
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/funcionarios/{id}")
	public Funcionario getFuncionarioById(@PathVariable Long id){
		return funcionarioRepository.findById(id).get();
	}	
	
	@PostMapping("/funcionarios")	
	@ResponseStatus (HttpStatus.CREATED)
	public Funcionario addFuncionario(@RequestBody @Valid Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	@DeleteMapping("/funcionarios/{id}")
	public void removeFuncionario(@PathVariable Long id){
		funcionarioRepository.deleteById(id);
	}	

}
