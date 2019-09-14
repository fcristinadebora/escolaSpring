package com.debora.aula1.entidades;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Escola {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private String cnpj;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "escola")
	private Collection<Aluno> alunoCollection;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "escola")
	private Collection<Professor> professorCollection;
}
