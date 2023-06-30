package com.example.demo.model;

import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Visitante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column (length=100)
	@NotBlank
	String nomeCompleto;
	
	@NotBlank
	@CPF
	String cpf;
	
	@Column (length=14)
	@NotBlank
	String telefone;
	
	@NotBlank
	String Motivo;

	String Observacao;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMotivo() {
		return Motivo;
	}

	public void setMotivo(String motivo) {
		Motivo = motivo;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Motivo, Observacao, cpf, id, nomeCompleto, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitante other = (Visitante) obj;
		return Objects.equals(Motivo, other.Motivo) && Objects.equals(Observacao, other.Observacao)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id)
				&& Objects.equals(nomeCompleto, other.nomeCompleto) && Objects.equals(telefone, other.telefone);
	}
	
	
}
