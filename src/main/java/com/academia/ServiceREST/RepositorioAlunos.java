package com.academia.ServiceREST;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.academia.Dao.AlunoDao;
import com.academia.Models.Aluno;

@ApplicationScoped
public class RepositorioAlunos {

	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private AlunoDao alunoDao = new AlunoDao();

	private List<Aluno> alunos = new ArrayList<>();

	@PersistenceContext
	private EntityManager manager;

	public Aluno buscaPorID(Integer id) {
		return manager.find(Aluno.class, id);
	}

	public List<Aluno> buscaAlunos() {

		this.alunos = alunoDao.listar();
		return alunos;

	}

}
