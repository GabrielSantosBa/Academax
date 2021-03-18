package com.academia.Bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.academia.Dao.AlunoDao;
import com.academia.Dao.MensalidadeDao;
import com.academia.Models.Aluno;
import com.academia.Models.Mensalidades;

@Named 
@RequestScoped
public class MensalidadeBean {

	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private MensalidadeDao contaDao;	
	@Inject
	private Mensalidades mensalidade;
	@Inject
	private AlunoDao alunoDao;
	@Inject
	private Aluno aluno;


	private Integer alunoId;
	


	public Mensalidades getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Mensalidades mensalidade) {
		this.mensalidade = mensalidade;
	}
	public Integer getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Integer alunoId) {
		this.alunoId = alunoId;
	}


	@Transactional // CREATE
	public Mensalidades cadastrarConta() {	
		
		Aluno aluno = alunoDao.buscaPorId(Aluno.class, alunoId);	
		
		this.mensalidade.getAluno();
		
		contaDao.insert(mensalidade);
		return mensalidade;		
	}

}
