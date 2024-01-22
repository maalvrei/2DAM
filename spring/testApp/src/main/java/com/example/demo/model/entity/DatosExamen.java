package com.example.demo.model.entity;

import java.util.ArrayList;

public class DatosExamen {

	public ArrayList<Contestacion> contestaciones = new ArrayList<>();

	public ArrayList<Contestacion> getContestaciones() {
		return contestaciones;
	}

	public void setContestaciones(ArrayList<Contestacion> contestaciones) {
		this.contestaciones = contestaciones;
	}
	
}
