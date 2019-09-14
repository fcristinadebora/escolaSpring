package com.debora.aula1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.debora.aula1.entidades.Aluno;
import com.debora.aula1.repositorios.AlunoRepository;

@Controller     
@RequestMapping(path="/aluno")  
public class AlunoController {
 
	@Autowired 
	private AlunoRepository alunoRepository;
	 
	@GetMapping(path="/adicionar")  
	public @ResponseBody String adicionarAluno (@RequestParam String nome) {
 
		Aluno alu = new Aluno();
		alu.setNome(nome);
 
		alunoRepository.save(alu);
		return "Salvo!";
	}
	
	@GetMapping(path="/todos")
	public @ResponseBody Iterable<Aluno> getAlunos() {
		//   retorna um JSON ou XML 
		return alunoRepository.findAll();
	}
}
