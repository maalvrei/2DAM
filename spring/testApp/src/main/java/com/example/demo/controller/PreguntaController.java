package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.IPreguntaService;

@Controller
@RequestMapping("/pregunta")
public class PreguntaController {
	
	@Autowired
	private IPreguntaService preguntaService;
	
	@GetMapping("/listar")
	public String listar (Model model) {
		model.addAttribute("preguntas", preguntaService.findAll());
		return "preguntas";
	}
	

}
