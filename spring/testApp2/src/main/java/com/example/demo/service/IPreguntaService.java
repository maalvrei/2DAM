package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.ModificacionPreguntaMC;
import com.example.demo.model.ModificacionPreguntaSC;
import com.example.demo.model.SolucionesTest;
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
	Pregunta formateaRespuestasPreguntaMC(Pregunta pregunta);
	Pregunta formateaRespuestasPreguntaSC(Pregunta pregunta);
	ModificacionPreguntaSC objetoParaModificarPreguntaSC(Pregunta pregunta);
	Pregunta preguntaSCDesdeObjeto(ModificacionPreguntaSC objeto);
	ModificacionPreguntaMC objetoParaModificarPreguntaMC(Pregunta pregunta);
	Pregunta preguntaMCDesdeObjeto(ModificacionPreguntaMC objeto);
	ArrayList<String> listasConRespuestas (Pregunta p);
	ArrayList<Pregunta> preguntasAcertadas (SolucionesTest datos);
	ArrayList<Pregunta> preguntasFalladas (SolucionesTest datos);
}
