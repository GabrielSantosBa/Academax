package com.academia.Bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.academia.Dao.AlunoDao;
import com.academia.Dao.MensalidadeDao;
import com.academia.Models.Aluno;
import com.academia.Models.Mensalidade;

@Named 
@RequestScoped
public class MensalidadeBean {

	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private MensalidadeDao contaDao;	
	@Inject
	private Mensalidade mensalidade;
	@Inject
	private AlunoDao alunoDao;


	private Integer alunoId;
	


	public Mensalidade getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Mensalidade mensalidade) {
		this.mensalidade = mensalidade;
	}
	public Integer getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Integer alunoId) {
		this.alunoId = alunoId;
	}


	@Transactional // CREATE
	public Mensalidade cadastrarConta() {	
		
		Aluno aluno = alunoDao.buscaPorId(Aluno.class, alunoId);	
		
		this.mensalidade.setAluno(aluno);
		
		contaDao.insert(mensalidade);
		return mensalidade;		
	}

}
