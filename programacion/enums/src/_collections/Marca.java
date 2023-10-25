package _collections;

import java.util.Random;

public enum Marca {
	
	AU("Audi"), VW("Volkswagen"), SE("Seat"), SK("Skoda"), BM("BMW");
	
	private String name;
	private static Random random = new Random();
	
	private Marca (String name) {
		this.name = name;
	}
	
	public static Marca MarcaAleatoria () {
		return Marca.values()[random.nextInt(Marca.values().length)];
	}
	
	public String getName() {
		return name;
	}
	
}
