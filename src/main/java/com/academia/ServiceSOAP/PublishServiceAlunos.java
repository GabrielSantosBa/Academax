package com.academia.ServiceSOAP;

import javax.xml.ws.Endpoint;

public class PublishServiceAlunos {

	public static void main(String[] args) {

		Alunos servicoAlunos = new Alunos();

		String URl = "http://localhost:8080/Academax/AlunosAcademia";

		Endpoint.publish(URl, servicoAlunos);

	}

}
