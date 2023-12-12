package com.example.demo.paquete;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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
	
	@GetMapping("formulario")
	public String m2(Model model) {
		List<String[]> listaConPreguntas = leeTXT();
		String pregunta1 = devuelveLaPregunta(listaConPreguntas);
		String pregunta2 = devuelveLaPregunta(listaConPreguntas);
		String pregunta3 = devuelveLaPregunta(listaConPreguntas);
		model.addAttribute("pregunta1", pregunta1);
		model.addAttribute("pregunta2", pregunta2);
		model.addAttribute("pregunta3", pregunta3);
		return "preguntas";
	}
	
	public static List<String[]> leeTXT() {
		File f = new File("C:\\Users\\migue\\Desktop\\pcp.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		int tamanioArray = 0;
		List <String[]> lineas = new ArrayList<>();
		br.lines().forEach(s-> lineas.add(s.split("\\|")));
		return lineas;
	}
	
	public static String devuelveLaPregunta(List<String[]> lista) {
		Random r = new Random();
		return lista.get(r.nextInt(0,lista.size()-1))[1];
	}
	
	public static void main(String[] args) {
		leeTXT();
	}
}
