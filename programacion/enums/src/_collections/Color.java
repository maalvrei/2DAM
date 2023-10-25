package _collections;

import java.util.Random;

public enum Color {

	RO("Rojo"), NA("Naranja"), AM("Amarillo"), AZ("Azul"), IN("Indigo"), VI("Violeta"), VE("Verde");
	
	private String name;
	private static Random random = new Random();
	
	private Color (String name) {
		this.name = name;
	}
	
	public static Color ColorAleatorio () {
		return Color.values()[random.nextInt(Color.values().length)];
	}
	
	public String getName() {
		return name;
	}
	
}
