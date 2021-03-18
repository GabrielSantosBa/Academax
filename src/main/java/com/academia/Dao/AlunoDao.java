package com.academia.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.academia.Bean.AlunoRetornadoBean;
import com.academia.Models.Aluno;

public class AlunoDao {

	AlunoRetornadoBean alunoRetornado = new AlunoRetornadoBean();

	@PersistenceContext
	private EntityManager manager;

	// CREATE
	public void insert(Aluno aluno) {
		manager.persist(aluno);
	}

	// READY
	public List<Aluno> listar() {
		String jpql = "SELECT l FROM Aluno l";
		return manager.createQuery(jpql, Aluno.class).getResultList();
	}
		
	// UPDATE
	public Aluno atualiza(Aluno aluno) {
		return manager.merge(aluno);
	}

	// Search By ID
	public Aluno buscaPorId(Aluno aluno) {
		return manager.find(Aluno.class, aluno.getId());
	}
	
	// Search By ID
		public Integer buscaPorIdInteger(Integer alunoId) {
			 manager.find(Aluno.class, alunoId);			 
			 return alunoId;
		}
	

	// DELETE
	public void remove(Aluno aluno) {
		manager.remove(manager.contains(aluno) ? "Está Managed" : manager.merge(aluno));
	}

	public Aluno buscaPorId(Class<Aluno> aluno, Integer alunoId) {
		// TODO Auto-generated method stub
		return manager.find(Aluno.class, alunoId);
	}

	

}
