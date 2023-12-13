package com.example.demo.model;

public class PreguntaSC extends Pregunta{
	String respuestaCorrecta;
	String respuesta1;
	String respuesta2;
	String respuesta3;
	String respuesta4;
	
	public PreguntaSC(String pregunta, String respuesta1, String respuesta2,
			String respuesta3, String respuesta4) {
		super(pregunta, "SC");
		this.respuestaCorrecta = respuesta1;
		this.respuesta1 = respuesta1;
		this.respuesta2 = respuesta2;
		this.respuesta3 = respuesta3;
		this.respuesta4 = respuesta4;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public String getRespuesta4() {
		return respuesta4;
	}
	
}
