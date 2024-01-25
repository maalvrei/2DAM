package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class PreguntaController {

	@Autowired
	private IPreguntaService preguntaService;
	
	@Autowired
	private InsultoService insultoService;

	@GetMapping("/home")
	public String home(Model model) {
		List<Integer> posicionesImagenes = new ArrayList<>();
		for (int i = 1 ; i <=8 ; i++) posicionesImagenes.add(i);
		Collections.shuffle(posicionesImagenes);
		Insulto insulto = insultoService.getInsulto();
		model.addAttribute("posiciones",posicionesImagenes);
		model.addAttribute("insulto",insulto.getInsult());
		return "home.html";
	}
	
	@GetMapping("/home/listar")
	public String listar(Model model) {
		model.addAttribute("preguntas", preguntaService.findAll());
		return "lista";
	}
	
	@PostMapping("/home/listar")
	public String listaFiltrada(Model model, @RequestParam String tipo) {
		model.addAttribute("preguntas", preguntaService.fillAllByType(tipo));
		System.out.println(tipo);
		return "lista";
	}
	

	@GetMapping("/home/formulario")
	public String crearPregunta(Model model) {
		model.addAttribute("pregunta", new Pregunta());
		return "formulario";
	}

	@PostMapping("/home/formulario")
	// Aquí cliente está ya poblado con los datos del formulario
	public String guardar(Pregunta pregunta) {
		preguntaService.save(pregunta);
		return "redirect:listar";
	}

	@GetMapping("/home/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		preguntaService.delete(id);
		return "redirect:/home/listar";
	}

	@GetMapping("/home/formulario/{id}")
	public String mofidicarPregunta(@PathVariable Long id, Model model) {
		Pregunta p = preguntaService.findById(id).orElse(null);
		model.addAttribute("pregunta", p);
		if (p.getTipo().equals("sc"))
			return "formulario_sc";
		else
			return "formulario_vf";
	}

	@GetMapping("/home/test")
	public String test(Model model) {
		List<Pregunta> preguntas = (ArrayList<Pregunta>) preguntaService.find10Aleatories();
		DatosExamen datos = new DatosExamen();
		for (Pregunta pregunta : preguntas) datos.contestaciones.add(new Contestacion());
		model.addAttribute("preguntas", preguntas);
		model.addAttribute("datos",datos);
		return "test";
	}

	@PostMapping("/home/test")
	public String compruebaTest(Model model, DatosExamen datos) {
		Long acertadas = datos.contestaciones.stream()
				.filter(c -> preguntaService.respuestaEsCorrecta(c.getIdPregunta(), c.getOpcionSeleccionada()))
				.count();
		List<Pregunta> preguntasFalladas = new ArrayList<>();
		List<Contestacion> contestacionesFalladas = new ArrayList<>();
		List<Pregunta> preguntasAcertadas = new ArrayList<>();
		List<Contestacion> contestacionesAcertadas = new ArrayList<>();
		datos.contestaciones.stream().forEach(c -> {
			Pregunta p = preguntaService.findById(c.getIdPregunta()).orElse(null);
			if (p.getRespuestaCorrecta().equals(c.getOpcionSeleccionada())) {
				preguntasAcertadas.add(p);
				contestacionesAcertadas.add(c);
			}
			else {
				preguntasFalladas.add(p);
				contestacionesFalladas.add(c);
			}
		});
		model.addAttribute("acertadas",acertadas);
		model.addAttribute("preguntasAcertadas",preguntasAcertadas);
		model.addAttribute("preguntasFalladas",preguntasFalladas);
		model.addAttribute("contestacionesAcertadas",contestacionesAcertadas);
		model.addAttribute("contestacionesFalladas",contestacionesFalladas);
		return "resultado_test.html";
	}

	/*
	 * @PostMapping("/home/testComprobar") public String sigueTest(Model
	 * model, @RequestParam String respuesta, HttpSession session, @RequestParam
	 * long id, @RequestParam int intento) { List<Pregunta> lista = (List<Pregunta>)
	 * session.getAttribute("lista"); lista.remove(lista.size()-intento); intento
	 * +=1; session.setAttribute("lista", lista); return "redirect:test"; }
	 */

}
