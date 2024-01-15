package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/home/modificar_pregunta")
	public String mofidicar_pregunta (@PathVariable Long id, Model model){
		model.addAttribute("pregunta",preguntaService.findById(id));
		return "modificar_pregunta";
	}
	

}
