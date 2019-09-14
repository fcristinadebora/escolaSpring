package com.debora.aula1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.debora.aula1.entidades.Turma;
import com.debora.aula1.repositorios.TurmaRepository;

@Controller     
@RequestMapping(path="/turma")  
public class TurmaController {
 
	@Autowired 
	private TurmaRepository turmaRepository;
		 
	@GetMapping(path="/adicionar")  
	public @ResponseBody String adicionarTurma (@RequestParam String nome) {
 
		Turma tur = new Turma();
		tur.setNome(nome);
 
		turmaRepository.save(tur);
		return "Salvo!";
	}
	
	@GetMapping(path="/todos")
	public @ResponseBody Iterable<Turma> getTurma() {
		//   retorna um JSON ou XML 
		return turmaRepository.findAll();
	}
}
