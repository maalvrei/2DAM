package com.example.demo.model;

public class PreguntaVF extends Pregunta {
	
	boolean opcionCorrecta;
	
	public PreguntaVF (String pregunta, String opcionCorrecta) {
		super(pregunta, "VF");
		this.opcionCorrecta = opcionCorrecta.equals("Verdadero")? true : false;
	}
	
}
