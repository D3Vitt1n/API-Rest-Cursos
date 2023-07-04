package com.curso.api.cursos;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.curso.api.entities.curso;


@TestInstance(Lifecycle.PER_CLASS)
class CursoTeste {
	
	curso c = new curso();
	
	@BeforeAll
	void iniciando() {
		System.out.println("Classe teste sendo iniciada");
	}
	
	@BeforeEach
	void antesDeCadaUm() {
		System.out.println("Testando um dos metodos");
//		c = new curso();
	}
	
	@AfterEach
	void depoisDeCadaUm() {
		System.out.println("Nome do curso: " + c.getNome());
		c = new curso();
	}
	
	@AfterAll
	void terminando() {
		System.out.println("Terminou...");
	}
	
	@Test
	void testaSetaNome() {
		c.setNome("Teste nome do curso");
		assertNotNull(c.getNome());
	}
	
	@Test
	void testarCursoNaoVazio() {
		
		curso c = new curso();
		assertNotNull(c);
	}
	
	@Test
	void valorDoCursoNaoNulo() {
		curso c = new curso();
		assertNotNull(c.getValorDoCurso());
	}
	
	@Test
	void testaNovoCursoValorZero() {
		
		curso Curso = new curso();
		Assertions.assertEquals(new BigDecimal(0), Curso.getValorDoCurso());
	}
	
	@Test
	void testaNovoCursoSemAluno() {
		
		curso Curso = new curso();
		Assertions.assertTrue(Curso.getAlunos().isEmpty());
	}
	
	
}
