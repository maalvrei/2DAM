package com.example.demo.model;

public class PreguntaVF extends Pregunta {
	
	boolean opcionCorrecta;
	
	public PreguntaVF (String enunciado, String opcionCorrecta) {
		super(enunciado, "VF");
		this.opcionCorrecta = opcionCorrecta.equals("Verdadero")? true : false;
	}
	
}
