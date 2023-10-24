package operadoresLogicos;

public class Ejercicio1 {

	public static void main(String[] args) {

		String nombre = "Maria";
		int edad = 54;
		boolean varon = false;

		System.out.printf(edad > 65 ? nombre + " es mayor de edad, y por lo tanto es jubilad%s "
				: nombre + " es menor de edad, y por lo tanto no es jubilad%s ", varon ? "o" : "a");
	}

}
