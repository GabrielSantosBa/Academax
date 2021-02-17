package com.academia.Bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.academia.Dao.AlunoDao;
import com.academia.Models.Aluno;
import com.academia.Util.Mensagens;

@Named
@ApplicationScoped
public class AlunoRetornadoBean {

	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private AlunoDao alunoDao;
	@Inject
	private Mensagens msg;

	private Aluno alunoReturn = new Aluno();

	public Aluno getAlunoReturn() {
		return alunoReturn;
	}

	@Transactional
	public String consultar(Aluno aluno) {
		alunoReturn = alunoDao.buscaPorId(aluno);
		return "editar?faces-redirect=true";
	}

	// UPDATE
	@Transactional
	public String atualizar(Aluno aluno) {
		try {
			msg.alteraSucesso();
			alunoDao.atualiza(alunoReturn);

		} catch (Exception e) {
			msg.err();
		}

		return "index?faces-redirect=true";
	}

}
