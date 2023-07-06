package com.example.demo.model;

import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity 								//Define class as a table in DataBase
@Table(name="aluno")
//@Data 									//Use of Lombok to avoid boiler plate (Getter & Setters)
@AllArgsConstructor 			        //Create Constructor with all arguments
@NoArgsConstructor					//Create Constructor with no arguments (Necessary for JPA)
public class Aluno {
	
	@Id 								//Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	@Column                             //Column at dataBase (Not Required but better to practice)
	Long id;
	
	@Column (nullable=false, length=100) 
	@NotBlank
	private String nomeCompleto;
	
	@Column (unique=true)
	@CPF
	private String cpf;
	
	@Column (unique=true, length=10)
	private Long matricula;
	
	@Column (nullable=false, length=14)
	private String telefone;
	
	@Column (length=10)
	private String turma;
	
	@Column(nullable = true)
	String foto;
	
	@ManyToOne
	@JoinColumn(name = "responsavelId")
    private Responsavel responsavel;
	
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private List<RelatorioAlunos>relatorioAlunos;
	
		
	
	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, foto, id, matricula, nomeCompleto, responsavel, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(foto, other.foto) && Objects.equals(id, other.id)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nomeCompleto, other.nomeCompleto)
				&& Objects.equals(responsavel, other.responsavel) && Objects.equals(telefone, other.telefone);
	}

	
	
	
}