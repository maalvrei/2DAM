package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pregunta {
	
	String enunciado;
	String tipo;
	
	public Pregunta(String pregunta, String tipo) {
		this.enunciado = pregunta;
		this.tipo = tipo;
	}

	public String getEnunciado() {
		return enunciado;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public static Pregunta preguntaAleatoria() {
		List <String[]> lineas = CargaDatos.leeTXT();
		List<Pregunta> listaDePreguntas = new ArrayList<>();
		for (String[] linea : lineas) {
			if (linea[0].equals("1")) {
				listaDePreguntas.add(new PreguntaVF(linea[1],linea[2]));
				System.out.println(linea[1]);
				}
			else if (linea[0].equals("2")) {
				listaDePreguntas.add(new PreguntaSC(linea[1],linea[2],linea[3],linea[4],linea[5]));
				System.out.println(linea[1]);
			}
		}
		return listaDePreguntas.get(new Random().nextInt(0,listaDePreguntas.size()-1));
	}
	
	public static void main(String[] args) {
		preguntaAleatoria();
	}
}
