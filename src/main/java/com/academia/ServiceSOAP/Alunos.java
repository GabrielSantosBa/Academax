package com.academia.ServiceSOAP;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.academia.Dao.AlunoDao;
import com.academia.Models.Aluno;

@WebService(serviceName = "AlunosAcademia")
public class Alunos {

	@Inject
	private AlunoDao alunoDao = new AlunoDao();

	private List<Aluno> alunos = new ArrayList<>();

	@PersistenceContext
	private EntityManager manager;

	public Aluno buscaPorID(int id) {
		return manager.find(Aluno.class, id);
	}

	@WebMethod(operationName = "TodosAlunos")
	@WebResult(name = "Aluno")
	public List<Aluno> buscaAlunos() {

		this.alunos = alunoDao.listar();
		return alunos;

	}
}
