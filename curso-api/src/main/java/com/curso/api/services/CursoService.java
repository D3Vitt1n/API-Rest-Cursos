package com.curso.api.services;

import java.util.List;


import com.curso.api.entities.curso;

public interface CursoService {
	public List<curso> getCursos();
	
	public curso save(curso Curso);
	
	public curso findById(Integer id);
	
	public List<curso> findByNome(String valor);
	
	public void update(curso Curso);
	
	public void deleteById (Integer id);
}
