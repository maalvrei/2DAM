package operadoresLogicos;

public class EjercicioArrays2 {

	public static void main(String[] args) {

		int inicio = 877878;
		int numElemn = 1000;
		int multiploDe = 7841;
		int[] arr = new int[numElemn];

		while (inicio % multiploDe != 0) {
			inicio++;
		};
		
		System.out.println("Inicio: " + inicio);
		
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
