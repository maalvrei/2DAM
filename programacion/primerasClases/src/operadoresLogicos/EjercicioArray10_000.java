package operadoresLogicos;

import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class EjercicioArray10_000 {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		int numElem = 10_000;
		
		int[] arrayAleatorios = new int[numElem];
		
		for (int i = 0 ; i < arrayAleatorios.length ; i++) {
			arrayAleatorios[i] = r.nextInt(1, 10_001);
		}
		
		/* int numeroMayor = arrayAleatorios[0];
		
		int numeroMenor = arrayAleatorios[0];
		
		for (int n : arrayAleatorios) {
			if (n > numeroMayor)
				numeroMayor = n;
			if (n < numeroMenor)
				numeroMenor = n;
		}
		
		System.out.println("El numero mayor es: " + numeroMayor);
		
		System.out.println("El numero menor es: " + numeroMenor);
		*/
		
		Arrays.sort(arrayAleatorios);
		
		/*numeroMayor = arrayAleatorios[arrayAleatorios.length-1];
		
		numeroMenor = arrayAleatorios[0];*/
		
		System.out.println("El numero mayor es: " + arrayAleatorios[arrayAleatorios.length-1]);
		
		System.out.println("El numero menor es: " + arrayAleatorios[0]);
		
	}
	
}
