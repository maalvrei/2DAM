package com.example.demo.paquete;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.Pregunta;



@Controller
public class FormularioController {
	
	@ModelAttribute(name = "pregunta")
	public Pregunta pregunta() {
		return Pregunta.preguntaAleatoria();
	}
	
	@GetMapping("formulario")
	public String m2(Model model) {
		return "preguntas";
	}
}
