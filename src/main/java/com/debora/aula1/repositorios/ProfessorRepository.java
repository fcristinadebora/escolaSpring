package com.debora.aula1.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.debora.aula1.entidades.Professor;
 

// Sera  AUTO IMPLEMENTADO pelo Spring em um Bean chamado professorRepository
// CRUD  

public interface ProfessorRepository  extends CrudRepository<Professor, Integer> {

}
