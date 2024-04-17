package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.entity.Pregunta;
import com.example.demo.model.Solucion;
import com.example.demo.model.SolucionesTest;
import com.example.demo.model.Insulto;
import com.example.demo.model.ModificacionPreguntaMC;
import com.example.demo.model.ModificacionPreguntaSC;
import com.example.demo.service.IPreguntaService;
import com.example.demo.service.InsultoService;
import com.example.demo.util.paginator.PageRender;

import jakarta.servlet.http.HttpSession;

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
		model.addAttribute("preguntas", preguntas);
		List<Integer> posicionesImagenes = new ArrayList<>();
		for (int i = 1; i <= 8; i++)
			posicionesImagenes.add(i);
		Collections.shuffle(posicionesImagenes);
		model.addAttribute("posiciones", posicionesImagenes);
		model.addAttribute("insulto",insultoService.getInsulto().getInsult());
		return "home.html";
	}
	
	@GetMapping("/informacion") 
	public String informacion(Model model) {
	model.addAttribute("informacion", preguntaService.informacion());
		return "informacion";
	}
	
	@GetMapping("/iniciandoTest")
	public String iniciandoTest(HttpSession session) {
		return "iniciandoTest";
	}
	
	@PostMapping("/iniciandoTest")
	public String testIniciado(@RequestParam String nombre, HttpSession session, Model model) {
		session.setAttribute("nombre", nombre);
		return "redirect:test";
	}
	
	@GetMapping("/test")
	public String test(Model model, HttpSession session) {
		String nombre = (String) session.getAttribute("nombre");
		model.addAttribute("nombre",nombre);
		ArrayList<Pregunta> listaCon10Preguntas = (ArrayList<Pregunta>) preguntaService.find10Aleatories();
		SolucionesTest datos = new SolucionesTest();
		ArrayList<ArrayList<String>> arrayListConRespuestasDeCadaPregunta = new ArrayList<>();
		for (Pregunta p : listaCon10Preguntas) {
			datos.soluciones.add(new Solucion());
			arrayListConRespuestasDeCadaPregunta.add(preguntaService.listasConRespuestas(p));
		}
		model.addAttribute("respuestas", arrayListConRespuestasDeCadaPregunta);
		model.addAttribute("datos", datos);
		model.addAttribute("preguntas", listaCon10Preguntas);
		return "test";
	}
	
	@GetMapping("/lista")
	public String lista(Model model) {
		List<Pregunta> preguntas = (ArrayList<Pregunta>) preguntaService.findAll();
		model.addAttribute("preguntas", preguntas);
		return "lista";
	}
	
	@GetMapping("/listar-paginado")
	public String listaPaginada(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Pregunta> preguntas = preguntaService.listarPaginado(pageRequest);
		PageRender<Pregunta> pageRender = new PageRender<>("/listar-paginado", preguntas); 
		model.addAttribute("titulo", "Listado de preguntas paginado");
		model.addAttribute("preguntas",preguntas);
		model.addAttribute("page", pageRender);
		return "lista_paginada";
	}
	
	@PostMapping("/lista")
	public String listaFiltrada(Model model, @RequestParam ("tipo") String tipo, @RequestParam ("tema") String tema) {
		model.addAttribute("preguntas",preguntaService.listaFiltrada(tipo, tema));
		return "lista";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarPregunta(@PathVariable Long id) {
	    preguntaService.delete(id);
	    return "redirect:/lista";
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
		Pregunta preguntaFormateada = preguntaService.formateaRespuestasPreguntaSC(pregunta);
		preguntaService.save(preguntaFormateada);
		return "redirect:lista";
	}

	@PostMapping("/mcCreada")
	public String guardaPreguntaMC(Pregunta pregunta) {
		Pregunta preguntaFormateada = preguntaService.formateaRespuestasPreguntaMC(pregunta);
		preguntaService.save(preguntaFormateada);
		return "redirect:lista";
	}

	@GetMapping("/modificar/{id}")
	public String modificarPregunta(Model model, @PathVariable Long id) {
		Pregunta p = preguntaService.findById(id).orElse(null);
		if (p.getTipo().equals("vf")) {
			model.addAttribute("pregunta", p);
			return "modificar_vf";
		} else if (p.getTipo().equals("sc")) {
			ModificacionPreguntaSC objetoDeModificacion = preguntaService.objetoParaModificarPreguntaSC(p);
			model.addAttribute("objeto", objetoDeModificacion);
			return "modificar_sc";
		} else {
			ModificacionPreguntaMC objetoDeModificacion = preguntaService.objetoParaModificarPreguntaMC(p);
			model.addAttribute("objeto", objetoDeModificacion);
			return "modificar_mc";
		}

	}

	@PostMapping("/scModificada")
	public String modificandoPreguntaSC(Model model, ModificacionPreguntaSC objeto) {
		Pregunta p = preguntaService.preguntaSCDesdeObjeto(objeto);
		preguntaService.save(p);
		return "redirect:lista";
	}

	@PostMapping("/mcModificada")
	public String modificandoPreguntaMC(Model model, ModificacionPreguntaMC objeto) {
		Pregunta p = preguntaService.preguntaMCDesdeObjeto(objeto);
		preguntaService.save(p);
		return "redirect:lista";
	}

	@PostMapping("/test")
	public String compruebaTest(Model model, SolucionesTest datos, HttpSession session) {
		
		ArrayList<Pregunta> preguntasRespondidasCorrectamente = preguntaService.preguntasAcertadas(datos);
		ArrayList<Pregunta> preguntasRespondidasIncorrectamente = preguntaService.preguntasFalladas(datos);
		ArrayList<Solucion> solucionesRespondidasCorrectamente = new ArrayList<>();
		ArrayList<Solucion> solucionesRespondidasIncorrectamente = new ArrayList<>();
		datos.soluciones.stream().forEach(s-> {
			Pregunta p = preguntaService.findById(s.getIdPregunta()).orElse(null);
			if (preguntasRespondidasCorrectamente.contains(p)) solucionesRespondidasCorrectamente.add(s);
			if (preguntasRespondidasIncorrectamente.contains(p)) solucionesRespondidasIncorrectamente.add(s);
		});
		String nombre = (String) session.getAttribute("nombre");
		model.addAttribute("nombre",nombre.toUpperCase());
		model.addAttribute("preguntasBien",preguntasRespondidasCorrectamente);
		model.addAttribute("preguntasMal",preguntasRespondidasIncorrectamente);
		model.addAttribute("solucionesBien", solucionesRespondidasCorrectamente);
		model.addAttribute("solucionesMal",solucionesRespondidasIncorrectamente);
		return "resultado_test";
	}

}