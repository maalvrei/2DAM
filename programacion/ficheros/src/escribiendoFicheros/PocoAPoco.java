package escribiendoFicheros;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PocoAPoco {

	public static void main(String[] args) {
		
		String linea1 = "Hola mundo";
		String linea2 = "Adios mundo";
		String[] lineas = {linea1, linea2};
		
		try (FileWriter fw = new FileWriter("src\\out.txt")) {
			for (int i = 0 ; i < lineas.length ; i++) {
				fw.append(lineas[i]);
				if (i != lineas.length - 1) fw.append("\n");
			}
		} catch (IOException e) {
			System.out.println("Problemas creando el archivo");
		} finally {
			System.out.println("Gracias por tu confianza");
		}
		
		try (FileReader fr = new FileReader("src\\out.txt")) {
			System.out.printf("Encoding: %s%n", fr.getEncoding());
			int c = 0;
			while ((c = fr.read()) != -1) {
				System.out.print((char)c);
			}
			System.out.println();
		} catch (IOException e) {
			System.out.println("Problemas abriendo el archivo");
		} finally {
			System.out.println("Gracias por tu confianza");
		}
	}
	
}
