package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home3Controller {
	
	@GetMapping("home/home3")
	public String m(Model model) {
		model.addAttribute("numeritoAleatorio", 3);
		model.addAttribute("titulo", "Mi bonita primera pagina");
		return "home/home3";
	}
	
}
