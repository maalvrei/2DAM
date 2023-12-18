package com.example.aplicacion.service;


import java.util.Random;
import org.springframework.stereotype.Service;
import com.example.aplicacion.model.CargaDatos;
import com.example.aplicacion.model.Pregunta;


@Service
public class PreguntaService {
	
	public Pregunta preguntaAleatoria() {
		int tamanioListaPreguntas = CargaDatos.listaDePreguntas().size();
		return CargaDatos.listaDePreguntas().get(new Random().nextInt(0,tamanioListaPreguntas-1));
	}

}
