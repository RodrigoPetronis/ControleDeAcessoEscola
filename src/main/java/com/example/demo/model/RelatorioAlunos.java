package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioAlunos {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String nomeCompleto;
	
	private String cpf;

	
	private Long matricula;
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime horaRegistro = LocalDateTime.now();
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
	

	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
				Id = id;
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


	public Long getMatricula() {
		return matricula;
	}


	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}


	public LocalDateTime getHoraRegistro() {
		return horaRegistro;
	}


	public void setHoraRegistro(LocalDateTime horaRegistro) {
		this.horaRegistro = horaRegistro;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Id, aluno, cpf, horaRegistro, matricula, nomeCompleto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelatorioAlunos other = (RelatorioAlunos) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(aluno, other.aluno) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(horaRegistro, other.horaRegistro) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(nomeCompleto, other.nomeCompleto);
	}
	
	

	
}
