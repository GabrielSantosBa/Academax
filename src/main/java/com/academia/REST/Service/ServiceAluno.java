package com.academia.REST.Service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.academia.Dao.AlunoDao;
import com.academia.Models.Aluno;


@SuppressWarnings("unused")
public class ServiceAluno {

	public ServiceAluno() {}
	
	@Inject
	private AlunoDao alunoDao;
	
	public Aluno cadastrarAluno(Aluno aluno) {
		return alunoDao.insert(aluno);
	}
	
	public List<Aluno> listarTodosAlunos(){
		return alunoDao.listar();
	}
	
	public Aluno buscarPorId(Integer id) {
		return alunoDao.buscaPorId(id);		
	}
	
	public void excluirAluno(Aluno aluno) {
		alunoDao.remove(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoDao.atualiza(aluno);
	}

}
