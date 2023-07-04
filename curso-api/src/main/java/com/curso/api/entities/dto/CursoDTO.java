package com.curso.api.entities.dto;

import java.io.Serializable;


import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;




public class CursoDTO implements Serializable {


	private static final long serialVersionUID = 1L;

	private Integer id;

	@NonNull
	@NotEmpty(message = "Nome esta vazio")
	@Size(min = 5, max = 20)
	private String nome;
	
	@NotBlank
	private String area;

	public CursoDTO() {

	}

	public CursoDTO(Integer id, String nome, String area) {
		super();
		this.id = id;
		this.nome = nome;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
