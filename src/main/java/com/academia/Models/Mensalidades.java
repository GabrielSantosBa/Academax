package com.academia.Models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.sun.istack.internal.NotNull;

@Entity
public class Mensalidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	@NotNull
	private BigDecimal valor;
	@jakarta.validation.constraints.NotNull
	private Date dataPagamento;
	
	public Mensalidades() {
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_aluno_mensalidade",joinColumns = @JoinColumn(name = "idaluno"),
	inverseJoinColumns = @JoinColumn(name = "cod"))
	private Aluno aluno;

	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
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
		Mensalidades other = (Mensalidades) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Mensalidades [cod=" + cod + ", valor=" + valor + ", dataPagamento=" + dataPagamento + ", aluno=" + aluno
				+ "]";
	}



}
