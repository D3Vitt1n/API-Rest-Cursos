package com.curso.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.curso.api.entities.curso;
import com.curso.api.repositories.CursoRepository;

@Component
@Profile(value= "test")
public class TesteDataBase  implements CommandLineRunner   {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public void run(String... args) throws Exception  {

		curso curso1 = new curso("Graduação em TI", "Exatas");
		curso curso2 = new curso("Graduação em Economia","Exatas");
		curso curso3 = new curso("Graduacão em Administração", "Humanas");
		curso curso4 = new curso("Graduacão em Educação Física", "Humanas");
		


		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		cursoRepository.save(curso3);
		cursoRepository.save(curso4);
		

	}
}
