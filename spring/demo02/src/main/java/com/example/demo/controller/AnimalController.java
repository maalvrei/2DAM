package com.example.demo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Animal;
import com.example.demo.service.IAnimalService;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private IAnimalService animalService;
	
	@ModelAttribute(name = "titulo")
	public String dameTitulo() {
		return "Animales";
	}

	@GetMapping("/un-animal")
	public String unAnimal(Model model) {
		Animal a1 = new Animal("Perro", 1100, 89.2);
		model.addAttribute("elAnimal",a1);
		model.addAttribute("cabecera","Mostrando un animal");
		model.addAttribute("subcabecera","Un gato");
		return "animal/un-animalito";
	}
	
	@GetMapping("/tabla-animal")
	public String tablaAnimales(Model model, @RequestParam(required = false, name = "filtro-tipo") String filtro) {
		List<Animal> listaGatos = animalService.generaListaGatos();
		model.addAttribute("cabecera","Lista de animales");
		model.addAttribute("subcabecera","Mostrando los datos de la lista de animales");
		if (filtro == null) model.addAttribute("listaAnimales",listaGatos);
		else model.addAttribute("listaAnimales",listaGatos.stream().filter(s-> s.getTipo().toLowerCase().equals(filtro)));
		return "animal/tablaAnimales";
	}
	
}
