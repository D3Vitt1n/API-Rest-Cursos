package com.curso.api.entities.mapper;

import org.springframework.stereotype.Service;

import com.curso.api.entities.curso;
import com.curso.api.entities.dto.CursoDTO;

@Service
public class CursoMapper {
	
	public curso mapDTOtoCurso(CursoDTO dto) {
		curso Curso = new curso(dto.getNome(),dto.getArea());
		
		return Curso;
	}
}
