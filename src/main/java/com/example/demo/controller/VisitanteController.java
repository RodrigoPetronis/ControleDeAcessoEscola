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

import com.example.demo.model.Visitante;
import com.example.demo.repository.VisitanteRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping
public class VisitanteController {
	
	@Autowired
	public VisitanteRepository visitanteRepository;
	
	@GetMapping("/visitantes")
	public List<Visitante> getAllVisitantes(){
		return visitanteRepository.findAll();
	}
	
	@GetMapping("/visitantes/{id}")
	public Visitante getVisitanteById(@PathVariable Long id){
		return visitanteRepository.findById(id).get();
	}
	
	@PostMapping("/visitantes")
	@ResponseStatus(HttpStatus.CREATED)
	public Visitante addVisitante(@RequestBody @Valid Visitante visitante) {
		return visitanteRepository.save(visitante);
	}
	
	@DeleteMapping("/visitantes/{id}")
	public void removeVisitanteById(@PathVariable Long id) {
		visitanteRepository.deleteById(id);
	}

}
