package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.entity.Pregunta;

public interface IPreguntaService {

	Optional<Pregunta> findById(Long id);
	Iterable<Pregunta> findAll();
	void save(Pregunta pregunta);
	void delete(Long id);
	
}
