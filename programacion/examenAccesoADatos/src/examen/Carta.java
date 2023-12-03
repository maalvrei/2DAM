package examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carta {

	String valor;
	String palo;
	static Random r = new Random();
	static String [] valores = {"A" ,"2","3","4","5","6","7","8","9","10","J","Q","K"};
	static String [] palos = {"Picas", "Corazones", "Treboles", "Diamantes"};
	
	public Carta(String valor, String palo) {
			this.valor = valor;
			this.palo = palo;
	}
	
	public static Carta cartaAleatoriaDeLaBaraja() {
		List<Carta> listaBaraja = new ArrayList<>();
		for (String s : valores) {
			listaBaraja.add(new Carta(s,palos[0]));
		}
		for (String s : valores) {
			listaBaraja.add(new Carta(s,palos[1]));
		}
		for (String s : valores) {
			listaBaraja.add(new Carta(s,palos[2]));
		}
		for (String s : valores) {
			listaBaraja.add(new Carta(s,palos[3]));
		}
		listaBaraja.add(new Carta("0", "Comodin"));
		listaBaraja.add(new Carta("0", "Comodin"));
		Carta[] Baraja = new Carta[listaBaraja.size()];
		Baraja = listaBaraja.toArray(Baraja);
		return Baraja[r.nextInt(0,Baraja.length)];
	}

}
