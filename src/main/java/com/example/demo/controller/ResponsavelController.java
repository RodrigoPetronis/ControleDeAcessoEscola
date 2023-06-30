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

import com.example.demo.model.Responsavel;
import com.example.demo.repository.ResponsavelRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping
public class ResponsavelController {
	
	@Autowired
	public ResponsavelRepository responsavelRepository;

	@GetMapping("/responsavel")
	public List<Responsavel>getAllResponsaveis(){
		return responsavelRepository.findAll();
	}
	
	@GetMapping("/responsavel/{id}")
	public Responsavel getResponsavelById(@PathVariable Long id){
		return responsavelRepository.findById(id).get();
	}
	
	@PostMapping("/responsavel")
	@ResponseStatus(HttpStatus.CREATED)
	public Responsavel addResponsavel(@RequestBody @Valid Responsavel responsavel) {
		return responsavelRepository.save(responsavel);
	}
	
	@DeleteMapping("/responsavel/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void removeResponsavel(@PathVariable Long id) {
		responsavelRepository.deleteById(id);
	}
	
}
