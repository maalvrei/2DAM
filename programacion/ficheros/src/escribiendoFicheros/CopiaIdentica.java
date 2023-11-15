package escribiendoFicheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopiaIdentica {

	public static void main(String[] args) {
		
		try (FileInputStream fis = new FileInputStream("C:\\Users\\Migue\\Pictures\\Captura.png"); FileOutputStream fos = new FileOutputStream("C:\\Users\\Migue\\Pictures\\Captura2.png");) {
			int b = 0;
			while((b = fis.read()) != -1) {
				fos.write(b);
			}
		} catch (Exception e) {
			System.out.println("Ha habido un problema con los archivos");
		} finally {
			System.out.println("Gracias por confiar en nosotros");
		}
		
	}
	
}
