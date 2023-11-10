package escribiendoFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cosa {

	int numero;
	char letra;
	private static Random r = new Random();
	
	public Cosa () {
		numero = r.nextInt(10) + 1;
		letra = (char) (r.nextInt('Z' - 'A' + 1 ) + 'A');
	}
	
	public Cosa (int numero, char letra) {
		this.numero = numero;
		this.letra = letra;
	}
	
	public String cosaFormateada() {
		return String.format("%d,%c%n", numero, letra);
	}
	
	public static void escribeEnArchivo (String ruta, int numeroCosas) {
		try (FileWriter fw = new FileWriter(ruta)) {
			for (int i = 0 ; i < numeroCosas ; i++) {
				fw.append(new Cosa().cosaFormateada());
			}
		} catch (IOException e) {
			System.out.println("Problemas creando el archivo");
		} finally {
			System.out.println("Gracias por tu confianza");
		}
	}
	
	public static void leeArchivo (String ruta) {
		
		FileReader fileR = null;
		
		try {
			fileR = new FileReader(ruta);
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");
		}
		
		String linea = "";
		List<Cosa> listaDeCosas = new ArrayList<>();
		
		try {
			int c = 0;
			while (((c = fileR.read()) != -1)) {
				linea+=(char)c;
			}
		} catch (Exception e) {
			
		}
		
		for (Cosa c : listaDeCosas) {
			System.out.println(c.toString());
		}
	}
	
	@Override
	public String toString() {
		return "Cosa [numero=" + numero + ", letra=" + letra + "]";
	}

	public static void main(String[] args) {
		String ruta = "C:\\Users\\Migue\\Desktop\\archivos file writer\\archivo.txt";
		escribeEnArchivo(ruta, 10);
		leeArchivo(ruta);
	}
	/*System.out.printf("Encoding: %s%n", fr.getEncoding());
			int c = 0;
			String linea = "";
			while ((c = fr.read()) != -1 && c != '\n' ) {
				linea+=String.valueOf(c);
				System.out.println(linea);
			}
			System.out.println();*/
}
