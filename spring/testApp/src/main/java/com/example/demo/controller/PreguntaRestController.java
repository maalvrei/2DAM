package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.entity.Pregunta;
import com.example.demo.service.IPreguntaService;

@RestController
@RequestMapping("/api")
public class PreguntaRestController {
	
	@Autowired
	private IPreguntaService preguntaService;
	
	@GetMapping("/preguntas")
	public Iterable<Pregunta> listarRest() {
		return preguntaService.findAll();
	}
	
	@GetMapping("/pregunta/{id}")
	public Optional<Pregunta> idRest(@PathVariable long id) {
		return preguntaService.findById(id);
	}
	
	@DeleteMapping("/pregunta/{id}")
	public void borrarPersona(@PathVariable Long id) {
		preguntaService.delete(id);
	}
	
	@PostMapping("/pregunta")
	public void crearPersona(@RequestBody Pregunta pregunta) {
	    preguntaService.save(pregunta);
	}
	
	@PutMapping("/pregunta")
	public void actualizarPregunta(@RequestBody Pregunta persona) {
	    preguntaService.save(persona);
	}
}
