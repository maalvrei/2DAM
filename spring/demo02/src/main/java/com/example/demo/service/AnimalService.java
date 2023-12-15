package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Animal;

@Service
public class AnimalService implements IAnimalService {

	@Override
	public List<Animal> generaListaGatos() {
		List<Animal> listaAnimales = new ArrayList<>();
		listaAnimales.add(new Animal("Gato", 1100, 89.2));
		listaAnimales.add(new Animal("Gato", 7000, 42.5));
		listaAnimales.add(new Animal("Gato", 100, 30.1));
		listaAnimales.add(new Animal("Gato", 50, 12.6));
		return listaAnimales;
	}
	
	@Override
	public List<Animal> generaListaPerros() {
		List<Animal> listaAnimales = new ArrayList<>();
		listaAnimales.add(new Animal("Perro", 1100, 89.2));
		listaAnimales.add(new Animal("Perros", 7000, 42.5));
		listaAnimales.add(new Animal("Perros", 100, 30.1));
		listaAnimales.add(new Animal("Perros", 50, 12.6));
		return listaAnimales;
	}
	
}
