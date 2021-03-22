package com.academia.REST;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.academia.Models.Aluno;
import com.academia.REST.Service.ServiceAluno;

@Path("/aluno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunosRest {

	
	public AlunosRest() {}

	@Inject
	private ServiceAluno service;

	@GET
	@Path("/")		
	public List<Aluno> findAll() {
		return service.listarTodosAlunos();
	}

	@GET
	@Path("/{id}")
	public Aluno findById(@PathParam("id") Integer id) {
		Aluno aluno = service.buscarPorId(id);
		if (aluno == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return aluno;
	}
	
	
	@POST
	@Transactional
	public Aluno cadastrarAluno(Aluno aluno) {
		return service.cadastrarAluno(aluno);
	}
	
	@DELETE
	@Path("/{id}")
	@Transactional
	public void deletarAluno(@PathParam("id") Integer id, Aluno aluno) {		
			
		aluno = service.buscarPorId(id);
		service.excluirAluno(aluno);
	}
	
	@PUT
	@Path("/{id}")
	@Transactional
	public Aluno atualizarAluno(@PathParam("id") Integer id, Aluno aluno) {		
		
		Aluno alunoAtualizado = service.buscarPorId(id);		
	
		alunoAtualizado.setCelular(aluno.getCelular());
		alunoAtualizado.setCpf(aluno.getCpf());
		alunoAtualizado.setDataNascimento(aluno.getDataNascimento());
		alunoAtualizado.setNome(aluno.getNome());		
		return service.atualizarAluno(alunoAtualizado);
	}
	
	
	

}
