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
		return "home.html";
	}
	
}