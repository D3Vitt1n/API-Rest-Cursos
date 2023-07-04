package com.curso.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "curso")
public class curso implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome_teste", nullable = false)
	private String nome;

	@Column(nullable = false)
	private String area;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")	
	@CreationTimestamp
	@Column(name = "data_de_criação")
	private LocalDateTime dataDeCriação;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@UpdateTimestamp
	@Column(name = "data_de_atualização")
	private LocalDateTime dataDeAtualizacao;

	private String usuario;

	@Transient
	private BigDecimal valorDoCurso;

	@OneToMany(mappedBy = "Curso")
	private List<Aluno> alunos = new ArrayList<>();

	@PostPersist
	private void aposPersistirDados() {
		this.nome = this.nome + " POST";
	}

	@PrePersist
	private void antesPersistirDados() {
		this.usuario = "admin";
	}

	public curso() {

		this.valorDoCurso = new BigDecimal(0);
	}

	public curso(String nome, String area) {
		super();
		this.nome = nome;
		this.area = area;
		this.valorDoCurso = new BigDecimal(0);
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

	public LocalDateTime getDataDeCriação() {
		return dataDeCriação;
	}

	public void setDataDeCriação(LocalDateTime dataDeCriação) {
		this.dataDeCriação = dataDeCriação;
	}

	public LocalDateTime getDataDeAtualizacao() {
		return dataDeAtualizacao;
	}

	public void setDataDeAtualizacao(LocalDateTime dataDeAtualizacao) {
		this.dataDeAtualizacao = dataDeAtualizacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValorDoCurso() {
		return valorDoCurso;
	}

	public void setValorDoCurso(BigDecimal valorDoCurso) {
		this.valorDoCurso = valorDoCurso;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "curso [id=" + id + ", nome=" + nome + ", area=" + area + "]";
	}

}
