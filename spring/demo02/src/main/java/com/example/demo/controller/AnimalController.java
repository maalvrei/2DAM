package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Animal;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	@ModelAttribute(name = "titulo")
	public String dameTitulo() {
		return "Animales";
	}
	
	private List<Animal> generaLista() {
		List<Animal> listaAnimales = new ArrayList<>();
		listaAnimales.add(new Animal("Perro", 1100, 89.2));
		listaAnimales.add(new Animal("Gato", 7000, 42.5));
		listaAnimales.add(new Animal("Pajaro", 100, 30.1));
		listaAnimales.add(new Animal("Pez", 50, 12.6));
		return listaAnimales;
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
		model.addAttribute("cabecera","Lista de animales");
		model.addAttribute("subcabecera","Mostrando los datos de la lista de animales");
		if (filtro == null) model.addAttribute("listaAnimales",generaLista());
		else model.addAttribute("listaAnimales",generaLista().stream().filter(s-> s.getTipo().toLowerCase().equals(filtro)));
		return "animal/tablaAnimales";
	}
	
}
