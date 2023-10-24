package ejercicioParking;

import java.util.Random;

public enum Color {
	RO("Rojo"), NA("Naranja"), AM("Amarillo"), VE("Verde"), IN("Indigo"), VI("Violeta");

	private String nombreColor;

	private Color(String nombreColor) {
		this.nombreColor = nombreColor;
	}

    @Override
	public String toString() {
    	return nombreColor;
    }
    
	public static Color obtieneColorAleatorio() {
		return Color.values()[new Random().nextInt(0, Color.values().length)];
	}

}
