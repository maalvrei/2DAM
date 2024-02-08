package com.example.demo.model;

import java.util.ArrayList;

public class Solucion {
	
	private ArrayList<String> opcionesSeleccionadas;
	private Long idPregunta;
	
	public ArrayList<String> getOpcionesSeleccionadas() {
		return opcionesSeleccionadas;
	}
	
	public void setOpcionesSeleccionadas(ArrayList<String> opcionesSeleccionadas) {
		this.opcionesSeleccionadas = opcionesSeleccionadas;
	}
	
	public Long getIdPregunta() {
		return idPregunta;
	}
	
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}
	
	public Solucion (Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public Solucion () {
		
	}
	
}
