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
import com.example.demo.model.CargaDatos;
import com.example.demo.model.Pregunta;

@Controller
public class FormularioController {
	@GetMapping("formulario")
	public String m2(Model model) {
		List<Pregunta> preguntas = CargaDatos.generaPreguntas(CargaDatos.leeTXT());
		Pregunta p = preguntas.get(new Random().nextInt(preguntas.size()-1));
		model.addAttribute("pregunta",p);
		return "preguntas";
	}
}
