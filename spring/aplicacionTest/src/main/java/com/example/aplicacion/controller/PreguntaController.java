package com.example.aplicacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.aplicacion.model.Pregunta;
import com.example.aplicacion.model.PreguntaVF;
import com.example.aplicacion.service.PreguntaService;


@Controller
public class PreguntaController {
	
	@Autowired
	private PreguntaService sp;
	
	@ModelAttribute(name = "pregunta")
	public Pregunta pregunta() {
		return sp.preguntaAleatoria();
	}
	
	@GetMapping("pregunta")
	public String m(Model model) {
		return "test/pregunta";
	}
	
	@PostMapping("pregunta")
	public String m2(@RequestParam (name ="resultado") String resultado, Model model) {
		boolean comprobacion = new PreguntaVF("2 + 2 son 5", "falso").getOpcionCorrecta().equals(resultado);
		model.addAttribute("comprobacion", comprobacion);
		return "test/resultadoPregunta";
	}
	
}
