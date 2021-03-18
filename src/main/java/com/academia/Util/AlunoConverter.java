package com.academia.Util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.academia.Models.Aluno;

@FacesConverter("alunoConverter")
public class AlunoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		if (id == null || id.trim().isEmpty())
			return null;
		Aluno aluno = new Aluno();
		aluno.setId(Integer.valueOf(id));
		return aluno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object alunoObj) {
		Aluno aluno = (Aluno) alunoObj;
		return aluno.getId().toString();
	}

}
