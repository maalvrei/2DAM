package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.entity.Pregunta;
import com.example.demo.model.Contestacion;
import com.example.demo.model.DatosExamen;
import com.example.demo.model.Insulto;
import com.example.demo.service.IPreguntaService;
import com.example.demo.service.InsultoService;
import com.example.demo.util.paginator.PageRender;
import org.springframework.data.domain.Pageable;

@Controller
public class PreguntaController {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IPreguntaService preguntaService;
	
	@Autowired
	private InsultoService insultoService;

	@GetMapping("/home")
	public String home(Model model) {
		List<Pregunta> preguntas = (ArrayList<Pregunta>) preguntaService.findAll();
		model.addAttribute("preguntas",preguntas);
		List<Integer> posicionesImagenes = new ArrayList<>();
		for (int i = 1 ; i <=8 ; i++) posicionesImagenes.add(i);
		Collections.shuffle(posicionesImagenes);
		model.addAttribute("posiciones",posicionesImagenes);
		return "home.html";
	}
	
	@GetMapping("/crearPregunta")
	public String crearPregunta(Model model) {
		model.addAttribute("pregunta", new Pregunta());
		return "crearPregunta";
	}
	
	@PostMapping("/vfCreada")
	public String guardaPreguntaVF(Pregunta pregunta) {
		preguntaService.save(pregunta);
		return "redirect:lista";
	}
	
	@PostMapping("/scCreada")
	public String guardaPreguntaSC(Pregunta pregunta) {
	    String[] respuestas = pregunta.getRespuestas().split("   ");
	    String respuestasPregunta = "";
	    for (int i = 0 ; i < 4 ; i++) {
	    	if (respuestas[i].charAt(0)==',') respuestas[i] = respuestas[i].replaceFirst(",", "");
	    	respuestasPregunta +=respuestas[i] + "|";
	    }
	    respuestasPregunta = respuestasPregunta.substring(0, respuestasPregunta.length()-1);
	    pregunta.setRespuestas(respuestasPregunta);
	    preguntaService.save(pregunta);
	    return "redirect:lista";
	}
	
	@GetMapping("/lista")
	public String lista (Model model) {
		List<Pregunta> preguntas = (ArrayList<Pregunta>) preguntaService.findAll();
		model.addAttribute("preguntas",preguntas);
		return "lista";
	}
	
}