package com.example.demo.model;

public class Pregunta {
	
	String pregunta;
	String tipo;
	
	public Pregunta(String pregunta, String tipo) {
		this.pregunta = pregunta;
		this.tipo = tipo;
	}

	public String getPregunta() {
		return pregunta;
	}
	
	public String getTipo() {
		return tipo;
	}
	
}
