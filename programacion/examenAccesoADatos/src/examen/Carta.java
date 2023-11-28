package examen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carta {

	boolean esComodin;
	String valor;
	String palo;
	static Random r = new Random();
	static char [] valores = {'A' , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 'J' , 'Q' , 'K'};
	static String [] palos = {"Picas", "Corazones", "Treboles", "Diamantes"};
	
	public Carta(String valor, String palo, boolean esComodin) {
		if (!esComodin) {
			this.esComodin = false;
			this.valor = valor;
			this.palo = palo;
		} else {
			this.esComodin = true;
			this.valor = null;
			this.palo = null;
		}
	}
	
	public static Carta cartaAleatoriaDeLaBaraja() {
		List<Carta> listaBaraja = new ArrayList<>();
		for (char c : valores) {
			listaBaraja.add(new Carta(c == 'A' || c == 'J' || c == 'Q' || c == 'K'? String.valueOf(c) : String.valueOf((int)c),palos[0], false));
		}
		for (char c : valores) {
			listaBaraja.add(new Carta(c == 'A' || c == 'J' || c == 'Q' || c == 'K'? String.valueOf(c) : String.valueOf((int)c),palos[1], false));
		}
		for (char c : valores) {
			listaBaraja.add(new Carta(c == 'A' || c == 'J' || c == 'Q' || c == 'K'? String.valueOf(c) : String.valueOf((int)c),palos[2], false));
		}
		for (char c : valores) {
			listaBaraja.add(new Carta(c == 'A' || c == 'J' || c == 'Q' || c == 'K'? String.valueOf(c) : String.valueOf((int)c),palos[3], false));
		}
		listaBaraja.add(new Carta(null, null, true));
		listaBaraja.add(new Carta(null, null, true));
		Carta[] arrayBaraja = new Carta[listaBaraja.size()];
		arrayBaraja = listaBaraja.toArray(arrayBaraja);
		return arrayBaraja[r.nextInt(0,arrayBaraja.length)];
	}
	
	@Override
	public String toString() {
		return esComodin? "La carta es un comodin" : "Es el " + valor + " de " + palo;
	}
	
}
