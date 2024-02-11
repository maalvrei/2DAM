package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.ModificacionPreguntaMC;
import com.example.demo.model.ModificacionPreguntaSC;
import com.example.demo.model.SolucionesTest;
import com.example.demo.model.entity.Pregunta;
import com.example.demo.model.repository.IPreguntaRepository;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	@Autowired
	IPreguntaRepository preguntaRepository;

	@Override
	@Transactional(readOnly = true)
	public Optional<Pregunta> findById(Long id) {
		return preguntaRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pregunta> findAll() {
		return preguntaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
	public boolean respuestaEsCorrecta(Long id, String opcionSeleccionada) {
		return preguntaRepository.findById(id).orElse(null).getRespuestaCorrecta().equals(opcionSeleccionada);
	}

	@Override
	public Iterable<Pregunta> fillAllByType(String type) {
		List<Pregunta> listaPreguntasDelTipo = ((List<Pregunta>) preguntaRepository.findAll()).stream()
				.filter(p -> p.getTipo().equals(type)).toList();
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
		for (int i = 1; i < respuestas.length; i++) {
			respuestasFormateadas = respuestasFormateadas + respuestas[i].replaceFirst(",", "|");
		}
		pregunta.setRespuestas(respuestasFormateadas);
		String[] respuestasCorrectas = pregunta.getRespuestaCorrecta().split("   ");
		String respuestasCorrectasFormateadas = respuestasCorrectas[0];
		for (int i = 1; i < respuestasCorrectas.length; i++) {
			boolean sonSoloComas = true;
			for (int j = 0; j < respuestasCorrectas[i].length(); j++) {
				if (respuestasCorrectas[i].charAt(j) != ',') {
					sonSoloComas = false;
				}
			}
			if (!sonSoloComas)
				respuestasCorrectasFormateadas += respuestasCorrectas[i].replaceFirst(",", "|");
		}
		pregunta.setRespuestaCorrecta(respuestasCorrectasFormateadas);
		return pregunta;
	}

	@Override
	public Pregunta formateaRespuestasPreguntaSC(Pregunta pregunta) {
		String[] respuestas = pregunta.getRespuestas().split("   ");
		String respuestasPregunta = "";
		for (int i = 0; i < 4; i++) {
			if (respuestas[i].charAt(0) == ',')
				respuestas[i] = respuestas[i].replaceFirst(",", "");
			respuestasPregunta += respuestas[i] + "|";
		}
		respuestasPregunta = respuestasPregunta.substring(0, respuestasPregunta.length() - 1);
		pregunta.setRespuestas(respuestasPregunta);
		return pregunta;
	}

	@Override
	public ModificacionPreguntaSC objetoParaModificarPreguntaSC(Pregunta pregunta) {
		ModificacionPreguntaSC mpsc = new ModificacionPreguntaSC();
		mpsc.setEnunciado(pregunta.getEnunciado());
		mpsc.setId(pregunta.getId());
		mpsc.setRespuestaCorrecta(pregunta.getRespuestaCorrecta());
		mpsc.setTema(pregunta.getTema());
		mpsc.setTipo(pregunta.getTipo());
		ArrayList<String> listaDeRespuestas = new ArrayList<>();
		for (String s : pregunta.getRespuestas().split("\\|"))
			listaDeRespuestas.add(s);
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
		for (int i = 0; i < objeto.getRespuestas().size(); i++) {
			if (i != objeto.getRespuestas().size() - 1)
				respuestas += objeto.getRespuestas().get(i) + "|";
			else
				respuestas += objeto.getRespuestas().get(i);
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
		for (String s : pregunta.getRespuestas().split("\\|"))
			listaDeRespuestas.add(s);
		mpmc.setRespuestas(listaDeRespuestas);
		ArrayList<String> listaDeRespuestasCorrectas = new ArrayList<>();
		for (String s : pregunta.getRespuestaCorrecta().split("\\|"))
			listaDeRespuestasCorrectas.add(s);
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
		for (int i = 0; i < objeto.getRespuestas().size(); i++) {
			if (i != objeto.getRespuestas().size() - 1)
				respuestas += objeto.getRespuestas().get(i) + "|";
			else
				respuestas += objeto.getRespuestas().get(i);
		}
		p.setRespuestas(respuestas);
		String respuestasCorrectas = "";
		for (int i = 0; i < objeto.getRespuestasCorrectas().size(); i++) {
			respuestasCorrectas += objeto.getRespuestasCorrectas().get(i);
			if (i != objeto.getRespuestasCorrectas().size() - 1 || !(objeto.getRespuestasCorrectas().get(i).equals("")))
				respuestasCorrectas += "|";
		}
		p.setRespuestaCorrecta(respuestasCorrectas);
		p.setTema(objeto.getTema());
		p.setTipo(objeto.getTipo());
		return p;
	}

	@Override
	public ArrayList<String> listasConRespuestas(Pregunta p) {
		ArrayList<String> respuestas = new ArrayList<>();
		if (!(p.getTipo().equals("vf"))) {

			for (String s : p.getRespuestas().split("\\|"))
				respuestas.add(s);
			Collections.shuffle(respuestas);
		} else
			respuestas.add(null);
		return respuestas;
	}

	@Override
	public ArrayList<Pregunta> preguntasAcertadas(SolucionesTest datos) {
		ArrayList<Pregunta> listaAcertadas = new ArrayList<>();
		datos.soluciones.stream().filter(s -> s.getOpcionesSeleccionadas()!=null).forEach(solucion -> {
			Pregunta p = preguntaRepository.findById(solucion.getIdPregunta()).orElse(null);
			if (p.getTipo().equals("mc")) {
				solucion.getOpcionesSeleccionadas().removeAll(Collections.singleton(null));
				ArrayList<String> respuestasCorrectasDeLaPregunta = new ArrayList<>(Arrays.asList(p.getRespuestaCorrecta().split("\\|")));
				System.out.println(respuestasCorrectasDeLaPregunta);
				System.out.println(solucion.getOpcionesSeleccionadas());
				if (respuestasCorrectasDeLaPregunta.containsAll(solucion.getOpcionesSeleccionadas()) && !solucion.getOpcionesSeleccionadas().isEmpty()) listaAcertadas.add(p);
			} else {
				String respuestaCorrectaDeLaPregunta = p.getRespuestaCorrecta();
				if (solucion.getOpcionesSeleccionadas().contains(respuestaCorrectaDeLaPregunta)) listaAcertadas.add(p);
			}
		});;
		return listaAcertadas;
	}

	@Override
	public ArrayList<Pregunta> preguntasFalladas(SolucionesTest datos) {
		ArrayList<Pregunta> listaFalladas = new ArrayList<>();
		datos.soluciones.stream().filter(s -> s.getOpcionesSeleccionadas()!=null && (!s.getOpcionesSeleccionadas().isEmpty())).forEach(solucion -> {
			Pregunta p = preguntaRepository.findById(solucion.getIdPregunta()).orElse(null);
			if (p.getTipo().equals("mc")) {
				solucion.getOpcionesSeleccionadas().removeAll(Collections.singleton(null));
				if (solucion.getOpcionesSeleccionadas().size() != p.getRespuestaCorrecta().split("\\|").length) listaFalladas.add(p);
				else {
					ArrayList<String> respuestasCorrectasDeLaPregunta = new ArrayList<>(Arrays.asList(p.getRespuestaCorrecta().split("\\|")));
					if (!respuestasCorrectasDeLaPregunta.containsAll(solucion.getOpcionesSeleccionadas())) listaFalladas.add(p);
					
				}
			} else {
				String respuestaCorrectaDeLaPregunta = p.getRespuestaCorrecta();
				if (!(solucion.getOpcionesSeleccionadas().contains(respuestaCorrectaDeLaPregunta))) listaFalladas.add(p);
			}
		});
		return listaFalladas;
	}

	@Override
	public List<Pregunta> listaFiltrada(String tipo, String tema) {
		List<Pregunta> listaFiltrada = (ArrayList<Pregunta>)preguntaRepository.findAll();
		if (tipo.equals("todos") && !tema.equals("todos"))
			listaFiltrada = listaFiltrada.stream().filter(p -> p.getTema().equals(tema)).toList();
		else if (!tipo.equals("todos") && tema.equals("todos"))
			listaFiltrada = listaFiltrada.stream().filter(p -> p.getTipo().equals(tipo)).toList();
		else if ((!tipo.equals("todos") && !tema.equals("todos")))
			listaFiltrada = listaFiltrada.stream().filter(p -> p.getTipo().equals(tipo)).filter(p-> p.getTema().equals(tema)).toList();
		for (Pregunta p : listaFiltrada) System.out.println(p.getEnunciado());
		return listaFiltrada;
	}
}
