package operadoresLogicos;

public class Operadores2 {

	static void programa() {
		
		int i = 8, j = 5;
		float x = 0.005F, y = -0.01F;
		char c = 'c', d = 'd';
		
		System.out.println("i <= j es false. Resultado real: " + (boolean)(i <= j));
		System.out.println("c > d es false. Resultado real: " + (boolean)(c > d));
		System.out.println("x >= 0 es false. Resultado real: " + (boolean)(x >= 0));
		System.out.println("x < y-- es false. Resultado real: " + (boolean)(x < y--));
		System.out.println("c == 99 es false. Resultado real: " + (boolean)(c == 99));
		System.out.println("!(i <= j) es true. Resultado real: " + (boolean)(!(i <= j)));
		System.out.println("!(c == 99) es false. Resultado real: " + (boolean)(!(c == 99)));
		System.out.println("!(x > 0) es false. Resultado real: " + (boolean)(!(x > 0)));
		
	}
	
	public static void main(String[] args) {
		programa();
	}
	
}
