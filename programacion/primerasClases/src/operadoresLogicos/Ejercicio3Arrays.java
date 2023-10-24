package operadoresLogicos;

public class Ejercicio3Arrays {

	public static void main(String[] args) {
		
		int numElem = 50_000;
		int multiploDe = 2;
		int inicio = 800;
		int primerMultiploDe = 0;
		int[] array = new int[numElem];
		
		// buscando el primer multiplo de multiploDe
		// empezando por inicio
		
		primerMultiploDe = ((inicio - 1)/multiploDe + 1) * multiploDe;
		
		System.out.println("El primer múltiplo de " + inicio + primerMultiploDe);
		// relleno el array invertido con los multiplos pedidos
		
		for (int i = 0; i < array.length; i++) {
			array[i] = primerMultiploDe + (array.length - i - 1) * multiploDe;
		}
		
		// Cálculo de la suma
		long suma = (primerMultiploDe + primerMultiploDe + multiploDe * (numElem - 1)) / 2 * numElem;
		long suma1 = 0;
		for(int elem: array) {
			System.out.println(elem);
			suma1 += elem;
		}
		System.out.println("Suma: " + suma);
		System.out.println("Suma1: " + suma1);
		
	}
	
}
