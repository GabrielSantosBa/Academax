package com.academia.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.academia.Models.Aluno;

public class AlunoDao {


	@PersistenceContext
	private EntityManager manager;

	// CREATE
	public Aluno insert(Aluno aluno) {
//		if (alun) {
//		throw new DaoException("O Produto Informado n�o e valido", ErrorCode.BAD_REQUEST.getCode());
//	}
		manager.persist(aluno);
		return aluno;
	}

	// READY
	public List<Aluno> listar() {
		String jpql = "SELECT l FROM Aluno l";
		return manager.createQuery(jpql, Aluno.class).getResultList();
	}
		
	// UPDATE
	public Aluno atualiza(Aluno aluno) {
		return manager.contains(aluno) ? null: manager.merge(aluno);
	}

	// Search By ID
	public Aluno buscaPorId(Integer id) {
		return manager.find(Aluno.class, id);
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
