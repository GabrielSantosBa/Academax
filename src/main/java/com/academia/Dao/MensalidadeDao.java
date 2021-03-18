package com.academia.Dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.academia.Models.Aluno;
import com.academia.Models.Mensalidades;

public class MensalidadeDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Inject
	private Aluno aluno;


	// INSERT
	public void insert(Mensalidades conta) {
		manager.persist(conta);		
		System.out.println("A CONTA "+conta);
	}

}