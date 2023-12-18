package com.example.aplicacion.model;

public class PreguntaVF extends Pregunta {
	
	String opcionCorrecta;
	
	public PreguntaVF (String enunciado, String opcionCorrecta) {
		super(enunciado, "VF", opcionCorrecta);
	}
	
}
