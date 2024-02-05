package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entity.Pregunta;
import com.example.demo.model.repository.IPreguntaRepository;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	@Autowired
	IPreguntaRepository preguntaRepository;
	
	@Override
	@Transactional (readOnly = true)
	public Optional<Pregunta> findById(Long id) {
		return preguntaRepository.findById(id);
	}

	@Override
	@Transactional (readOnly = true)
	public Iterable<Pregunta> findAll() {
		return preguntaRepository.findAll();
	}
	
	@Override
	@Transactional (readOnly = true)
	public Iterable<Pregunta> find10Aleatories() {
		List<Pregunta> listaDeTodas = (List<Pregunta>) preguntaRepository.findAll();
		List<Pregunta> listaCon10Aleatorias = new ArrayList<>();
		Collections.shuffle(listaDeTodas);
		listaDeTodas.stream().limit(10).forEach(p -> listaCon10Aleatorias.add(p));
		return listaCon10Aleatorias;
	}

	@Override
	@Transactional
	public void save(Pregunta pregunta) {
		preguntaRepository.save(pregunta);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		preguntaRepository.deleteById(id);
	}

	@Override
	@Transactional (readOnly = true)
	public boolean respuestaEsCorrecta(Long id, String opcionSeleccionada) {
		return preguntaRepository.findById(id).orElse(null).getRespuestaCorrecta().equals(opcionSeleccionada);
	}

	@Override
	public Iterable<Pregunta> fillAllByType(String type) {
		List<Pregunta> listaPreguntasDelTipo = ((List<Pregunta>) preguntaRepository.findAll()).stream().filter(p -> p.getTipo().equals(type)).toList();
		return listaPreguntasDelTipo;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Pregunta> listarPaginado(Pageable pageable) {
		return preguntaRepository.findAll(pageable);
	}
	

}
