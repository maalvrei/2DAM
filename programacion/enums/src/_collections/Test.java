package _collections;

public class Test {

	public static void main(String[] args) {
		
		Parking p1 = new Parking ("P-1", 10);
		Coche c1 = new Coche(Color.AM,Marca.AU);
		Coche c2 = new Coche(Color.AM,Marca.AU);
		p1.entraCoche(c1);
		p1.entraCoche(c2);
		p1.reportParking();
		/*Coche c = new Coche();
		System.out.println("------");
		System.out.println(p1.entraCoche(c));
		System.out.println(p1.entraCoche(c));*/
		p1.reportMarcas();
		p1.reportColores();
		p1.reportCochesIguales();
		p1.reportSetCoches();
		
	}
	
}
