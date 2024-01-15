package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Transactional
	public void save(Pregunta pregunta) {
		preguntaRepository.save(pregunta);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		preguntaRepository.deleteById(id);
		
	}

}
