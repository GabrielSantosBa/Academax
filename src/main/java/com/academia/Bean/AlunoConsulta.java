package com.academia.Bean;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.academia.Dao.AlunoDao;
import com.academia.Models.Aluno;


@Named
@ViewScoped
public class AlunoConsulta {

	@Inject
	private AlunoDao alunoDao;
	

	public List<Aluno> buscarAlunos() {
		return alunoDao.listarIdNome();
	}


	@Override
	public String toString() {
		return "AlunoConsulta [alunoDao=" + alunoDao + "]";
	}
	
	
	
}
