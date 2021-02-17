package com.academia.Models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	private BigDecimal valor;
	private Date dataPagamento;
	
	public Conta() {
	}
	
	@ManyToOne
	@JoinColumn(name = "id_tb_aluno")
	private Aluno alunos;

	public Integer getCod() {
		return cod;
	}

	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	@Override
	public String toString() {
		return "Conta [cod=" + cod + ", valor=" + valor + ", dataPagamento=" + dataPagamento + "]";
	}

	
	
	


}
