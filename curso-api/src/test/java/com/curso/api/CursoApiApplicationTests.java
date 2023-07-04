package com.curso.api;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.api.entities.curso;
import com.curso.api.services.CursoService;


@SpringBootTest
class CursoApiApplicationTests {

	
	@Autowired
	private CursoService cursoService;
	
	@Test
	void contextLoads() {
	List<curso> cursos = cursoService.getCursos();
		System.out.println("Cursos");
		System.out.println(cursos);
	}
	
	

}
