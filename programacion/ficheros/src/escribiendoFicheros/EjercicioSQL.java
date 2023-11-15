package escribiendoFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class EjercicioSQL {

	private String[] arrayDeNombres = arrayNombres(
			"C:\\Users\\Migue\\Desktop\\repo segundo año\\2DAM\\programacion\\ficheros\\src\\escribiendoFicheros\\nombres.txt");
	private String[] arrayDeApellidos = arrayApellidos(
			"C:\\Users\\Migue\\Desktop\\repo segundo año\\2DAM\\programacion\\ficheros\\src\\escribiendoFicheros\\apellidos.txt");

	public String[] getArrayDeNombres() {
		return arrayDeNombres;
	}

	public String[] getArrayDeApellidos() {
		return arrayDeApellidos;
	}

	public static String[] arrayNombres(String ruta) {

		String[] arrayNombres = null;

		try (BufferedReader brNombres = new BufferedReader(new FileReader(ruta))) {
			arrayNombres = brNombres.readLine().split(",");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < arrayNombres.length; i++) {
			arrayNombres[i] = arrayNombres[i].trim();
		}

		return arrayNombres;

	}

	public static String[] arrayApellidos(String ruta) {

		String[] arrayDeApellidos = null;

		try (BufferedReader brNombres = new BufferedReader(new FileReader(ruta))) {
			arrayDeApellidos = brNombres.readLine().split(",");
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < arrayDeApellidos.length; i++) {
			arrayDeApellidos[i] = arrayDeApellidos[i].trim();
		}

		return arrayDeApellidos;

	}

	public static void escribeSentencias(String ruta) {

		try (BufferedWriter bwDatos = new BufferedWriter(new FileWriter(ruta))) {
			for (int i = 0; i <= 10_000; i++) {
				Persona p = new Persona();
				if (i == 0)
					bwDatos.append(String.format(
							"INSERT INTO personas (nombre, apellido1, apellido2, nacido) VALUES ('%s','%s','%s','%d'),%n",
							p.nombre, p.apellido1, p.apellido2, p.nacido));
				else
					if (i >0 && i<10_000) {
						bwDatos.append(String.format(
								"('%s','%s','%s','%d'),%n",
								p.nombre, p.apellido1, p.apellido2, p.nacido));
					} else
						bwDatos.append(String.format(
								"('%s','%s','%s','%d');%n",
								p.nombre, p.apellido1, p.apellido2, p.nacido));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		escribeSentencias(
				"C:\\Users\\Migue\\Desktop\\repo segundo año\\2DAM\\programacion\\ficheros\\src\\escribiendoFicheros\\sentenciaSQL.txt");
	}

}
