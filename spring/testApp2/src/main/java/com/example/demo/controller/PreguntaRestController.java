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
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/api")
@Api(tags = "API de Preguntas", description = "Operaciones relacionadas con preguntas")
public class PreguntaRestController {
	
	@Autowired
	private IPreguntaService preguntaService;
	
	@GetMapping("/preguntas")
	@ApiOperation("Obtener todas las preguntas")
	public Iterable<Pregunta> listarRest() {
		return preguntaService.findAll();
	}
	
	@GetMapping("/pregunta/{id}")
	@ApiOperation("Obtener una pregunta por su ID")
	public Optional<Pregunta> idRest(@PathVariable long id) {
		return preguntaService.findById(id);
	}
	
	@DeleteMapping("/pregunta/{id}")
	@ApiOperation("Eliminar una pregunta por su ID")
	public void borrarPregunta(@PathVariable Long id) {
		preguntaService.delete(id);
	}
	
	@PostMapping("/pregunta")
	@ApiOperation("Crear una pregunta")
	public void crearPregunta(@RequestBody Pregunta pregunta) {
	    preguntaService.save(pregunta);
	}
	
	@PutMapping("/pregunta")
	@ApiOperation("Modificar una pregunta por su ID")
	public void actualizarPregunta(@RequestBody Pregunta persona) {
	    preguntaService.save(persona);
	}
}
