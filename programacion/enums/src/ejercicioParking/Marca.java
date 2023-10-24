package ejercicioParking;

import java.util.Random;

public enum Marca {
	
	VW("Volkswagen"), HO("Honda"), AU("Audi"), TO("Toyota"), CH("Chevrolet");
	
	private String nombreMarca;

	private Marca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	
	@Override
	public String toString() {
    	return nombreMarca;
    }
	
	public static Marca obtieneMarcaAleatoria() {
		return Marca.values()[new Random().nextInt(0, Marca.values().length)];
	}
	
}
