package com.debora.aula1.entidades;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Matricula {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Date dataHora;
	private int ano;
	private int sequencia;
	
	@ManyToOne(optional = true)
	private Curso curso;
	
	@ManyToOne(optional = true)
	private Turma turma;
	
	@ManyToOne(optional = true)
	private Aluno aluno;
	
	@JoinTable(name = "matricula_disciplina",
			joinColumns = {
					@JoinColumn(name = "matricula_id", referencedColumnName = "id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "disciplina_id", referencedColumnName = "id")
			}
		)
	@ManyToMany
	private Collection<Disciplina> disciplinaCollection;
}
