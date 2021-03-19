package com.academia.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.academia.Dao.AlunoDao;
import com.academia.Models.Aluno;
import com.academia.Util.Mensagens;


@Named
@RequestScoped
public class AlunoBean   {

	private Aluno aluno = new Aluno();
	
	
	
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private AlunoDao alunoDao;
	@Inject
	private Mensagens msg;
	
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Transactional // CREATE
	public Aluno cadastrarAluno() {

		try {
			alunoDao.insert(aluno);
			msg.info();
			return aluno = new Aluno();

		} catch (Exception e) {
			msg.err();
		}
		return aluno;
	}

	@Transactional // READY
	public List<Aluno> consultarAlunos() {
		this.alunosAll = alunoDao.listar();
		return alunosAll;
	}

	@Transactional // DELETE
	public void remover(Aluno aluno) {

		try {
			alunoDao.remove(aluno);
			msg.deleteSucess();
		} catch (Exception e) {
			msg.err();
		}
	}

	@Transactional
	public void alunoId(Aluno aluno) {
		alunoDao.buscaPorId(aluno);
	}
	
	private List<Aluno> alunosAll = new ArrayList<>();
	
	public List<Aluno> getAlunosAll() {
		return alunosAll;
	}

	
	
	

}
