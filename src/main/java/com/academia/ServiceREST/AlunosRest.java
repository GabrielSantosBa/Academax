package com.academia.ServiceREST;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.academia.Models.Aluno;

@Path("/alunos")
@RequestScoped
public class AlunosRest {

	@Inject
	private RepositorioAlunos repoAlunos;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aluno> listandoAlunos() {
		return repoAlunos.buscaAlunos();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Aluno paramAlunoId(@PathParam("id") int id) {
		Aluno aluno = repoAlunos.buscaPorID(id);
		if (aluno == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return aluno;
	}

}
