package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Responsavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	 
	@Column (nullable=false, length=100) 
	@NotBlank
	private String nomeCompleto;
	
	@Column (unique=true)
	@CPF
	@NotBlank
	private String cpf;

	@Column (length=14)
	@NotBlank
	private String telefone;
	
	@Column (length=100)
	@NotBlank
	String endereco;
	
	@Column (nullable = false)
	@NotBlank
	String senha;
	
	@Column(nullable = true)
	String foto;
	
	@OneToMany // = Aluno.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "responsavelId")
	private List<Aluno> alunos = new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alunos, cpf, endereco, foto, id, nomeCompleto, senha, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsavel other = (Responsavel) obj;
		return Objects.equals(alunos, other.alunos) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(foto, other.foto)
				&& Objects.equals(id, other.id) && Objects.equals(nomeCompleto, other.nomeCompleto)
				&& Objects.equals(senha, other.senha) && Objects.equals(telefone, other.telefone);
	}
	

    
    
}
