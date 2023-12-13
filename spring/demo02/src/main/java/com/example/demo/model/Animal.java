package com.example.demo.model;

public class Animal {
	
	String tipo;
	int peso;
	double precio;
	
	public Animal(String tipo, int peso, double precio) {
		this.tipo = tipo;
		this.peso = peso;
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public int getPeso() {
		return peso;
	}

	public double getPrecio() {
		return precio;
	}
	
}
