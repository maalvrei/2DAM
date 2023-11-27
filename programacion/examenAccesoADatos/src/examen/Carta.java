package examen;

import java.util.Random;

public class Carta {

	String valor;
	String palo;
	boolean esComodin;
	Random r = new Random();
	
	char [] valores = {'A' , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 'J' , 'Q' , 'K'};
	String [] palos = {"Picas", "Corazones", "Treboles", "Diamantes"};
	
	public Carta() {
		esComodin = r.nextBoolean();
		if(!esComodin) {
			char valorChar =  valores[r.nextInt(0,valores.length)];
			if (valorChar == 'A' || valorChar == 'J' || valorChar == 'Q' || valorChar == 'K')
				valor = String.valueOf(valorChar);
			else
				valor = String.valueOf((int)valorChar);
			palo = palos[r.nextInt(0, palos.length)];
		}
	}
	
	@Override
	public String toString() {
		return esComodin? "La carta es un comodin" : "Es el " + valor + " de " + palo;
	}
	
}
