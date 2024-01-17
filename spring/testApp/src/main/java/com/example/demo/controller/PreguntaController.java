package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entity.Pregunta;
import com.example.demo.service.IPreguntaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PreguntaController {

	@Autowired
	private IPreguntaService preguntaService;

	@GetMapping("/home/listar")
	public String listar(Model model) {
		model.addAttribute("preguntas", preguntaService.findAll());
		return "lista";
	}
	
	@ResponseBody
	@GetMapping("/rest/listar")
	public Iterable<Pregunta> listarRest() {
		return preguntaService.findAll();
	}
	
	@ResponseBody
	@GetMapping("/rest/listar/{id}")
	public Optional<Pregunta> idRest(@PathVariable long id) {
		return preguntaService.findById(id);
	}

	@GetMapping("/home")
	public String home(Model model) {
		return "home";
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
		List<Pregunta> listaDePreguntas = (List<Pregunta>) preguntaService.findAll();
		Pregunta p = null;
		for (Pregunta pr : listaDePreguntas)
			if (pr.getId() == id)
				p = pr;
		model.addAttribute("pregunta", p);
		if (p.getTipo().equals("sc"))
			return "formulario_sc";
		else
			return "formulario_vf";
	}

	/*@GetMapping("/home/test")
	public String test(Model model, HttpSession session) {
		int intento = 0;
		@SuppressWarnings("unchecked")
		List<Pregunta> lista = (List<Pregunta>) session.getAttribute("lista");
		if (lista == null)
			lista = (List<Pregunta>) preguntaService.find10Aleatories();
		model.addAttribute("pregunta", lista.get(intento));
		model.addAttribute("intento", intento);
		model.addAttribute("lista", lista);
		return "test";
	}

	@PostMapping("/home/testComprobar")
	public String sigueTest(Model model, @RequestParam String respuesta, HttpSession session, @RequestParam long id, @RequestParam int intento) {
		List<Pregunta> lista = (List<Pregunta>) session.getAttribute("lista");
		lista.remove(lista.size()-intento);
		intento +=1;
		session.setAttribute("lista", lista);
		return "redirect:test";
	}*/

}
