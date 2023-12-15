package com.example.demo.paquete;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaludoController {
	
	@Value("Buenos días")
	private String saludoDia;
	
	@Value("Buenas noches")
	private String saludoNoche;
	
	@Value("Buenas tardes")
	private String saludoTarde;
	
	@ModelAttribute(name = "titulo")
	public String titulo() {
		return "Saludos";
	}
	
	@GetMapping("/saludos/{time}/{nombre}")
	public String m2(Model model, @PathVariable int time, @PathVariable String nombre) {
		model.addAttribute("saludo",(time == 3 ? saludoNoche : time == 2 ? saludoTarde : saludoDia) + " " + nombre);
		return "saludos/saludo";
	}
}
