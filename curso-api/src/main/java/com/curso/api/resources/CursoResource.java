package com.curso.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.api.entities.curso;
import com.curso.api.entities.dto.CursoDTO;
import com.curso.api.entities.mapper.CursoMapper;
import com.curso.api.services.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private CursoMapper mapper;

	@GetMapping
	public ResponseEntity<List<curso>> getCursos() {

		List<curso> lista = cursoService.getCursos();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<curso> findCurso(@PathVariable Integer id) {
		curso Curso = cursoService.findById(id);
		return ResponseEntity.ok().body(Curso);
	}

	@GetMapping("/nome")
	public ResponseEntity<List<curso>> findCurso(@RequestParam String valor) {
		List<curso> Cursos = cursoService.findByNome(valor);
		return ResponseEntity.ok().body(Cursos);

	}

	@PostMapping
	public ResponseEntity<curso> saveCurso(@Valid @RequestBody CursoDTO dto) throws URISyntaxException {
		curso NovoCurso = cursoService.save(mapper.mapDTOtoCurso(dto));
		return ResponseEntity.created(new URI("/cursos/salva" + NovoCurso.getId())).body(NovoCurso);
	}

	@PutMapping("/{id}")
	public ResponseEntity<curso> updateCurso(@Valid @RequestBody CursoDTO dto, @PathVariable Integer id) {

		curso novo = (mapper.mapDTOtoCurso(dto));
		novo.setId(id);

		cursoService.update(novo);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCurso(@PathVariable Integer id) {
		cursoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
