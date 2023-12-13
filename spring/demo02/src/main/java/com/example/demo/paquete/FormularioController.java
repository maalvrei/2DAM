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

@Controller
public class FormularioController {
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
		File f = new File("C:\\Users\\Migue\\Desktop\\pcp.txt");
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
}
