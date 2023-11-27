package examen;

import java.util.Random;

public enum Moneda {
	Cara("Cara"), Cruz("Cruz");

	private String ladoDeLaMoneda;

	private Moneda(String ladoDeLaMoneda) {
		this.ladoDeLaMoneda = ladoDeLaMoneda;
	}

	@Override
	public String toString() {
		return ladoDeLaMoneda;
	}

	public static Moneda obtieneMonedaAleatoria() {
		return Moneda.values()[new Random().nextInt(0, Moneda.values().length)];
	}
}