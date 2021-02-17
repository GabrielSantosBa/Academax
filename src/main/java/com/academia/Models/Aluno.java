package com.academia.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CPF;


@Entity
public class Aluno implements Serializable {

	

	private static final long serialVersionUID = -5843387401969060323L;

	@Id
	@GeneratedValue
	@Column(name = "id_tb_aluno", nullable = false)
	private Integer id = 1;
	private String nome;
	private String celular;
	
	@CPF
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	
	public Aluno() {
	}
	
	@OneToMany(mappedBy = "alunos", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Conta> conta = new ArrayList<>();

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", celular=" + celular + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", conta=" + conta + "]";
	}
	
	
	


}