package com.debora.aula1.entidades;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@EqualsAndHashCode 
@ToString
@Getter
@Setter
public class Professor {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String nome;
 
    private String email;
    
    
    @ManyToOne(optional = false)
	private Escola escola;
	 
    @ManyToMany(mappedBy = "professorCollection")
	private Collection<Disciplina> disciplinaCollection;

}