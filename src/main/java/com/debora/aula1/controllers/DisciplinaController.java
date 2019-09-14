package com.debora.aula1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.debora.aula1.entidades.Disciplina;
import com.debora.aula1.repositorios.DisciplinaRepository;

@Controller     
@RequestMapping(path="/disciplina")  
public class DisciplinaController {
 
	@Autowired 
	private DisciplinaRepository disciplinaRepository;
	 
	@GetMapping(path="/adicionar")  
	public @ResponseBody String adicionarDisciplina (@RequestParam String nome
			, @RequestParam Integer cargaHoraria) {
 
		Disciplina disc = new Disciplina();
		disc.setNome(nome);
		disc.setCargaHoraria(cargaHoraria);
 
		disciplinaRepository.save(disc);
		return "Salvo!";
	}
	
	@GetMapping(path="/todos")
	public @ResponseBody Iterable<Disciplina> getDisciplinas() {
		//   retorna um JSON ou XML 
		return disciplinaRepository.findAll();
	}
}
