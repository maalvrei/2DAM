package com.example.demo.model.entity;

public class Contestacion {
	
	private String opcionSeleccionada;
	private Long idPregunta;
	
	public String getOpcionSeleccionada() {
		return opcionSeleccionada;
	}
	
	public void setOpcionSeleccionada(String opcionSeleccionada) {
		this.opcionSeleccionada = opcionSeleccionada;
	}
	
	public Long getIdPregunta() {
		return idPregunta;
	}
	
	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}
	
	public Contestacion (Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public Contestacion () {
		
	}
	
}
