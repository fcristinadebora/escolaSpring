package com.debora.aula1.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String cep;
	private String numero;
	private String rua;
	private String cidade;
	private String uf;
	
	@OneToOne(mappedBy = "endereco")
	private Aluno aluno;
}
