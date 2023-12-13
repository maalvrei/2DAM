package com.example.demo.paquete;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping({"home",""})
	public String homeMethod() {
		return "home";
	}
	
	@GetMapping("home-aleatoria")
	public String m(Model model) {
		Random random = new Random();
		int miRandom = random.nextInt();
		model.addAttribute("miRandom", miRandom);
		return "htmlAleatorio";
	}
	
}
