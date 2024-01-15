package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.entity.Pregunta;
import com.example.demo.service.IPreguntaService;

@Controller
public class PreguntaController {
	
	@Autowired
	private IPreguntaService preguntaService;
	
	@GetMapping("/home/listar")
	public String listar (Model model) {
		model.addAttribute("preguntas", preguntaService.findAll());
		return "lista";
	}
	
	@GetMapping("/home")
	public String home (Model model) {
		return "home";
	}
	
	@GetMapping("/home/formulario")
	public String crearPregunta (Model model) {
		model.addAttribute("pregunta", new Pregunta());
		return "formulario";
	}
	
	@PostMapping("/home/formulario")
	// Aquí cliente está ya poblado con los datos del formulario
	public String guardar(Pregunta pregunta) {
		preguntaService.save(pregunta);
		return "redirect:listar";
	}
	
	@GetMapping("/home/eliminar/{id}")
	public String eliminar (@PathVariable Long id) {
		preguntaService.delete(id);
		return "redirect:/home/listar";
	}
	
	@GetMapping("/home/formulario/{id}")
	public String mofidicarPregunta (@PathVariable Long id, Model model){
		List<Pregunta> listaDePreguntas = (List<Pregunta>) preguntaService.findAll();
		Pregunta p = null;
		for (Pregunta pr : listaDePreguntas)
			if (pr.getId() == id) p = pr;
		model.addAttribute("pregunta",p);
		return "formulario";
	}
	

}
