package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.entity.Pregunta;

public interface IPreguntaService {

	Optional<Pregunta> findById(Long id);
	Iterable<Pregunta> findAll();
	Iterable<Pregunta> find10Aleatories();
	void save(Pregunta pregunta);
	void delete(Long id);
	boolean respuestaEsCorrecta(Long id, String opcionSeleccionada);
	Iterable<Pregunta> fillAllByType(String type);
	Page<Pregunta> listarPaginado(Pageable pageable);
}
