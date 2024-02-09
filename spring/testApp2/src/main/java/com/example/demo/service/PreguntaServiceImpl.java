package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.ModificacionPreguntaMC;
import com.example.demo.model.ModificacionPreguntaSC;
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

	@Override
	public Pregunta formateaRespuestasPreguntaMC(Pregunta pregunta) {
		String[] respuestas = pregunta.getRespuestas().split("   ");
		String respuestasFormateadas = respuestas[0];
		for (int i = 1 ; i < respuestas.length ; i++) {
			respuestasFormateadas = respuestasFormateadas + respuestas[i].replaceFirst(",", "|");
		}
		pregunta.setRespuestas(respuestasFormateadas);
		String[] respuestasCorrectas = pregunta.getRespuestaCorrecta().split("   ");
		String respuestasCorrectasFormateadas = respuestasCorrectas[0];
		for (int i = 1 ; i < respuestasCorrectas.length ; i++) {
			boolean sonSoloComas = true;
			for (int j = 0; j < respuestasCorrectas[i].length(); j++) {
	            if (respuestasCorrectas[i].charAt(j) != ',') {
	                sonSoloComas = false;
	            }
	        }
			if (!sonSoloComas) respuestasCorrectasFormateadas += respuestasCorrectas[i].replaceFirst(",", "|");
		}
		pregunta.setRespuestaCorrecta(respuestasCorrectasFormateadas);
	    return pregunta;
	}

	@Override
	public Pregunta formateaRespuestasPreguntaSC(Pregunta pregunta) {
		String[] respuestas = pregunta.getRespuestas().split("   ");
	    String respuestasPregunta = "";
	    for (int i = 0 ; i < 4 ; i++) {
	    	if (respuestas[i].charAt(0)==',') respuestas[i] = respuestas[i].replaceFirst(",", "");
	    	respuestasPregunta +=respuestas[i] + "|";
	    }
	    respuestasPregunta = respuestasPregunta.substring(0, respuestasPregunta.length()-1);
	    pregunta.setRespuestas(respuestasPregunta);
	    return pregunta;
	}
	
	@Override
	public ModificacionPreguntaSC objetoParaModificarPreguntaSC (Pregunta pregunta) {
		ModificacionPreguntaSC mpsc= new ModificacionPreguntaSC();
		mpsc.setEnunciado(pregunta.getEnunciado());
		mpsc.setId(pregunta.getId());
		mpsc.setRespuestaCorrecta(pregunta.getRespuestaCorrecta());
		mpsc.setTema(pregunta.getTema());
		mpsc.setTipo(pregunta.getTipo());
		ArrayList<String> listaDeRespuestas = new ArrayList<>();
		for (String s : pregunta.getRespuestas().split("\\|")) listaDeRespuestas.add(s);
		mpsc.setRespuestas(listaDeRespuestas);
		return mpsc;
	}

	@Override
	public Pregunta preguntaSCDesdeObjeto(ModificacionPreguntaSC objeto) {
		Pregunta p = new Pregunta();
		p.setEnunciado(objeto.getEnunciado());
		p.setId(objeto.getId());
		p.setRespuestaCorrecta(objeto.getRespuestaCorrecta());
		String respuestas = "";
		for (int i = 0 ; i < objeto.getRespuestas().size() ; i++) {
			if (i!=objeto.getRespuestas().size()-1)
				respuestas+=objeto.getRespuestas().get(i) + "|";
			else
				respuestas+=objeto.getRespuestas().get(i);
		}
		p.setRespuestas(respuestas);
		p.setTema(objeto.getTema());
		p.setTipo(objeto.getTipo());
		return p;
	}

	@Override
	public ModificacionPreguntaMC objetoParaModificarPreguntaMC(Pregunta pregunta) {
		ModificacionPreguntaMC mpmc = new ModificacionPreguntaMC();
		mpmc.setEnunciado(pregunta.getEnunciado());
		mpmc.setId(pregunta.getId());
		ArrayList<String> listaDeRespuestas = new ArrayList<>();
		for (String s : pregunta.getRespuestas().split("\\|")) listaDeRespuestas.add(s);
		mpmc.setRespuestas(listaDeRespuestas);
		ArrayList<String> listaDeRespuestasCorrectas = new ArrayList<>();
		for (String s : pregunta.getRespuestaCorrecta().split("\\|")) listaDeRespuestasCorrectas.add(s);
		mpmc.setRespuestasCorrectas(listaDeRespuestasCorrectas);
		mpmc.setTema(pregunta.getTema());
		mpmc.setTipo(pregunta.getTipo());
		return mpmc;
	}

	@Override
	public Pregunta preguntaMCDesdeObjeto(ModificacionPreguntaMC objeto) {
		Pregunta p = new Pregunta();
		p.setEnunciado(objeto.getEnunciado());
		p.setId(objeto.getId());
		String respuestas = "";
		for (int i = 0 ; i < objeto.getRespuestas().size() ; i++) {
			if (i!=objeto.getRespuestas().size()-1)
				respuestas+=objeto.getRespuestas().get(i) + "|";
			else
				respuestas+=objeto.getRespuestas().get(i);
		}
		p.setRespuestas(respuestas);
		String respuestasCorrectas = "";
		for (int i = 0 ; i < objeto.getRespuestasCorrectas().size() ; i++) {
				respuestasCorrectas+=objeto.getRespuestasCorrectas().get(i);
				if (i!=objeto.getRespuestasCorrectas().size()-1 || !(objeto.getRespuestasCorrectas().get(i).equals("")))
					respuestasCorrectas+= "|";
		}
		p.setRespuestaCorrecta(respuestasCorrectas);
		p.setTema(objeto.getTema());
		p.setTipo(objeto.getTipo());
		return p;
	}

	@Override
	public ArrayList<ArrayList<String>> listasConRespuestas(ArrayList<ArrayList<String>> arrayList, Pregunta p) {
		if (!(p.getTipo().equals("vf"))) {
			ArrayList<String> respuestas = new ArrayList<>();
			for (String s : p.getRespuestas().split("\\|")) respuestas.add(s);
			Collections.shuffle(respuestas);
			arrayList.add((ArrayList<String>)respuestas);
		} else
			arrayList.add(null);
		return arrayList;
	}
}
