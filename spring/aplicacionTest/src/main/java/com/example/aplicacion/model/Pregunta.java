package com.example.aplicacion.model;

public class Pregunta {
	
	String enunciado;
	String tipo;
	String opcionCorrecta;
	
	public Pregunta(String pregunta, String tipo, String opcionCorrecta) {
		this.enunciado = pregunta;
		this.tipo = tipo;
		this.opcionCorrecta = opcionCorrecta.toLowerCase();
	}

	public String getEnunciado() {
		return enunciado;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getOpcionCorrecta () {
		return opcionCorrecta;
	}

}
