package escribiendoFicheros;

import java.util.Random;

public class Persona {

	String nombre;
	String apellido1;
	String apellido2;
	int nacido;
	String[] nombres = new EjercicioSQL().getArrayDeNombres();
	String[] apellidos = new EjercicioSQL().getArrayDeApellidos();
	Random r = new Random();

	public Persona() {
		nombre = nombres[r.nextInt(0, nombres.length)];
		apellido1 = apellidos[r.nextInt(0, apellidos.length)];
		apellido2 = apellidos[r.nextInt(0, apellidos.length)];
		nacido = r.nextInt(1920, 2024);
	}
}
