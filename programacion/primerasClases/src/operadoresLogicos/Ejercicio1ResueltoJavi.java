package operadoresLogicos;

public class Ejercicio1ResueltoJavi {

	public static void main(String[] args) {

		int edad = 10;
		boolean varon = true;
		String nombre = "Sergio";

		System.out.printf(edad < 18 ? nombre + " es menor de edad"
				: edad < 65 ? nombre + "es mayor de edad" : nombre + " es jubilad%s", varon ? "o" : "a");

	}

}
