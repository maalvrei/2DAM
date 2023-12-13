package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dado")
public class DadoController {

	@Value("Dados")
	private String titulo;
	
	@GetMapping("/lanzar-dado")
	public String lanzaUnDado(Model model) {
		Random r = new Random();
		int lanzamiento = r.nextInt(0,7);
		model.addAttribute("titulo",titulo);
		model.addAttribute("lanzamiento",lanzamiento);
		return "dados/lanzar-dado";
	}
	
	@GetMapping("/lanzar-dos-dados")
	public String lanzaDosDado(Model model) {
		Random r = new Random();
		int lanzamiento1 = r.nextInt(1,7);
		int lanzamiento2 = r.nextInt(1,7);
		model.addAttribute("titulo",titulo);
		model.addAttribute("lanzamiento1",lanzamiento1);
		model.addAttribute("lanzamiento2",lanzamiento2);
		return "dados/lanzar-dos-dados";
	}
}
