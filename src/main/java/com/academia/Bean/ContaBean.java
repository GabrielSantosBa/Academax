package com.academia.Bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.academia.Dao.ContaDao;
import com.academia.Models.Conta;

@Named 
@RequestScoped
public class ContaBean {

	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private ContaDao contaDao;	
	@Inject
	private Conta conta;

	private Integer alunoId;
	


	public Integer getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Integer alunoId) {
		this.alunoId = alunoId;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	

	@Transactional // CREATE
	public void cadastrarConta() {		
		contaDao.insert(conta);		
	}

}
