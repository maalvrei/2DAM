package operadoresLogicos;

public class Operadores1 {

	static boolean W = false;
	static boolean X = true;
	static boolean Y = true;
	static boolean Z = false;
	
	public static void programa () {
		
		boolean r1 = W || Y && X && W || Z;
		boolean r2 = X && !Y && !X || !W && Y;
		boolean r3 = !(W || !Y) && X || Z;
		boolean r4 = X && Y && W || Z || X;
		boolean r5 = Y || !(Y || Z && W);
		boolean r6 = !X && Y && (!Z || !X);
		
		System.out.println("a) W || Y && X && W || Z => false"
				+ "\nb) X && !Y && !X || !W && Y => " + r2
				+ "\nc) !(W || !Y) && X || Z => " + r3
				+ "\nd) X && Y && W || Z || X => " + r4
				+ "\ne) Y || !(Y || Z && W) => " + r5 
				+ "\nf) !X && Y && (!Z || !X) => " + r6);
	}
	
	public static void main(String[] args) {

		/*
		 * Si W, X, Y y Z son variables de tipo boolean con valores W = false, X = true,
		 * Y = true, Z = false, determina el valor de las siguientes expresiones
		 * lógicas:
		 */
		
		// * a) W || Y && X && W || Z = false
		// * b) X && !Y && !X || !W && Y = true
		// * c) !(W || !Y) && X || Z = true
		// * d) X && Y && W || Z || X = true
		// * e) Y || !(Y || Z && W) = true
		// * f) !X && Y && (!Z || !X) = false

		/*
		 * Realiza a continuación un programa que ofrezca la siguiente salida para todas
		 * y cada una de las líneas anteriores tal y como se muestra en el ejemplo (se
		 * han sustituido los valores por XX para no desvelar la solución, dejando solo
		 * el caso a) con datos).
		 */
		
		programa();

	}
}
