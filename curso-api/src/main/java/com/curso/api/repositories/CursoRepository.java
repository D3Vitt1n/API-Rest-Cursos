package com.curso.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.api.entities.curso;

public interface CursoRepository extends JpaRepository<curso, Integer> {
	List<curso> findByNomeContaining(String nome);
	List<curso> findByArea(String area);
	List<curso> findCursoByNomeContaining(String valor);
	List<curso> findCursoByNomeLike(String valor);
	List<curso> findCursoByNomeLikeIgnoreCase(String valor);
	
	@Query(value = "Select c FROM curso c")
	List<curso> findByQueryNome();
	
	@Query(value = "Select nome_teste FROM curso where area = 'Exatas'", nativeQuery = true)
	List<String> findByQueryNomePorArea();
	
	@Query(value = "Select nome_teste FROM curso where area = :area", nativeQuery = true)
	List<String> findByQueryNomePorAreaInformada(@Param("area") String area);
	
	@Query(value = "Select nome_teste FROM curso where area = :area and nome_teste = :nome", nativeQuery = true)
	List<String> findByQueryNomePorAreaInformada2(@Param("area") String area, @Param("nome") String nome);
	
	@Query(value = "Select nome_teste FROM curso where area = ?1 and nome_teste = ?2", nativeQuery = true)
	List<String> findByQueryNomePorAreaParametros( String area, String nome);
}
