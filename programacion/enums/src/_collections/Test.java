package _collections;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		Parking p1 = new Parking ("P-1", 1_000_000);
		for (int i = 0; i< 1_000_000 ; i++)
			p1.entraCoche(new Coche());
		//p1.entraCoche(c1);
		//p1.entraCoche(c2);
		//p1.reportParking();
		/*Coche c = new Coche();
		System.out.println("------");
		System.out.println(p1.entraCoche(c));
		System.out.println(p1.entraCoche(c));*/
		//p1.reportMarcas();
		//p1.reportColores();
		//p1.reportCochesIguales();
		p1.reportSetCoches();
		
		List<Coche> coches = new ArrayList<>();
		
		for (int i = 0; i < 1_000_000; i++) {
			coches.add(new Coche());
		}

		long vwRojo = coches.stream().filter(coche -> coche.getMarca() == Marca.VW && coche.getColor() == Color.RO)
				.count();
		
		System.out.println("Hay " + vwRojo + " volkswagen rojos en el parking");
		
		p1.reportColores();
		
	}
	
}
