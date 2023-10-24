package operadoresLogicos;

public class EjercicioArrays {

	public static void main(String[] args) {

		int inicio = 800;
		int numElemn = 1000;
		int multiploDe = 2;
		int[] arr = new int[numElemn];
		
		for (int i = 0 ; i < arr.length ; i++) {
			arr[i] = inicio + (arr.length - i - 1)*2;
		}
		
		long suma = 0;
		
		for (int elem : arr) {
			System.out.println(elem);
			suma+= elem;
		}
		
		System.out.println("Suma: " + suma );
	}

}
