package _collections;

public class Test {

	public static void main(String[] args) {
		
		Parking p1 = new Parking ("P-1", 20);
		for (int i = 0; i<=20 ; i++)
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
		
	}
	
}
