package operadoresLogicos;

public class EjerciciosFor1 {

	public static void main(String[] args) {

		// a) Entre 50 y 2500 hay XX números múltiplos de 13.

		int numInicio = 50;
		int numFinal = 2500;
		int multlipoDe = 13;
		int cantidadMultiplosDe13 = 0;

		for (int i = numInicio; i <= numFinal; i++) {
			if (i % 13 == 0)
				cantidadMultiplosDe13++;
		}

		System.out.println("En total hay " + cantidadMultiplosDe13 + " multiplos de 13");

		// b) La cuenta atrás de 7 en 7 desde 1935 a 1812 es: XX XX ... XX

		numInicio = 1935;
		numFinal = 1812;
		int restando = 7;

		System.out.println("La cuenta atras de " + restando + " en " + restando + " es ");

		for (int i = numInicio; i <= numFinal; i--) {
			System.out.print(numInicio - restando);
		}

		// c) El producto de los números impares entre 10 y 20 es XX.
		// d) La suma de los números entre 70 y 800 es XXX.
		// f) La suma de los cuadrados de los numeros pares entre 15 y 70 es XXX.
		// g) La suma de los cubos de los numeros impares entre -10 y 20 es XXX.
		// h) El abecedario inglés de letras minúsculas es: abcdefghijklmnopqrstuvwxyz
		// i) El abecedario inglés de letras mayúsculas es: ABCDEFGHIJKLMNOPQRSTUVWXYZ
		// j) El abecedario inglés de letras minúsculas de 3 en 3 letras es: adgjmpsvy
		
		/*System.out.print("El abecedario inglés de letras minúsculas de 3 en 3 letras es: ");
		
		for(char i = 'a' ; i <= 'z' ; i++)
			System.out.print(i+3);*/
		
		// k) El abecedario inglés de letras minúsculas alrevés es:
		// zyxwvutsrqponmlkjihgfedcba
		// l) El abecedario inglés alternando mayúsculas y minúsculas es:
		// AbCdEfGhIjKlMnOpQrStUvWxYz
		
		char[] abecedarioEnIngles = new char['z' + 1 -'a'];
		
		int indice = 0;
		
		for (int i = 'a' ; i <= 'z' ; i++) {
			abecedarioEnIngles[indice] = (char) i;
			indice++;
		}
		
		System.out.println("El abecedario en ingles alternando mayusculas y minusculas es: ");
		
		for (int i = 0 ; i < abecedarioEnIngles.length ; i++) {
			if (i % 2 == 0)
				System.out.print((char)(abecedarioEnIngles[i] - 32));
			else
				System.out.print(abecedarioEnIngles[i]);
		}
		
		System.out.println("El abecedario en ingles alternando mayusculas y minusculas es: ");
		
		for(char i = 'a' ; i <= 'z' ; i++)
			System.out.print(i % 2 == 0 ? i : (char)(i-32));
		
	}

}
