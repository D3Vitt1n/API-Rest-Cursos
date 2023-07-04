package com.curso.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.api.entities.curso;
import com.curso.api.repositories.CursoRepository;
import com.curso.api.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public List<curso> getCursos() {
		return cursoRepository.findAll();
	}

	@Override
	public curso save(curso Curso) {
		Curso.setId(null);
		return cursoRepository.save(Curso);
	}

	@Override
	public curso findById(Integer id) {
		
		Optional<curso> Curso = cursoRepository.findById(id);
		
		return Curso.orElse(null);
	}

	@Override
	public List<curso> findByNome(String valor) {
		return cursoRepository.findByNomeContaining(valor);
	}

	@Override
	public void update(curso Curso) {
		
		curso atual = this.findById(Curso.getId());
		
		atual.setNome(Curso.getNome());
		atual.setArea(Curso.getArea());
		
		cursoRepository.save(atual);
		
	}

	@Override
	public void deleteById(Integer id) {
		
		cursoRepository.deleteById(id);
		
	}



}
