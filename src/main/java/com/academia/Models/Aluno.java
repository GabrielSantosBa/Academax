package com.academia.Models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Aluno implements Serializable {

	

	private static final long serialVersionUID = -5843387401969060323L;

	@Id
	@GeneratedValue
	@Column(name = "idaluno", nullable = false)
	private Integer id = 1;
	
	private String nome;
	
	private String celular;
	
	
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@JsonbDateFormat(value = "dd-MM-yyyy")
	private Calendar dataNascimento;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "aluno")
//	private List<ContaAluno> mensalidade;
	
	

	public Aluno() {
	}
	

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", celular=" + celular + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + "]";
	}

	
	
	


}