package com.debora.aula1.entidades;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Disciplina {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private Integer cargaHoraria;
	
	@ManyToMany(mappedBy = "disciplinaCollection")
	private Collection<Matricula> matriculaCollection;
	
	@JoinTable(name = "disciplina_profesor",
			joinColumns = {
					@JoinColumn(name = "disciplina_id", referencedColumnName = "id")
			},
			inverseJoinColumns = {
					@JoinColumn(name = "professor_id", referencedColumnName = "id")
			}
		)
	@ManyToMany
	private Collection<Professor> professorCollection;
}
