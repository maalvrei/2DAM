package com.example.demo.model;

import java.util.ArrayList;

public class ModificacionPreguntaSC {

	public ArrayList<String> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	ArrayList<String> respuestas;
	String respuestaCorrecta;
	String tipo;
	String tema;
	Long id;
	String enunciado;
}
