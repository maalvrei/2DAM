package directorio;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileUtils {

	public static boolean analiza(File f) {
		if (f == null)
			return false;
		if (!f.exists())
			return false;
		
		System.out.println("Permiso de lectura : " + f.canRead() + "\nPermiso de escritura: " + f.canWrite()
				+ "\nPermiso de ejecucion: " + f.canExecute());
		String fileEsUn = f.isDirectory() ? "directorio" : "archivo";
		System.out.printf("Nombre del %s: %s%n", fileEsUn, f.getName());
		System.out.println("Nombre del parent: " + f.getParent());
		
		if (f.isDirectory()) {
			List<File> nombresEnLista = Arrays.asList(f.listFiles());
			System.out.println("\nListado de archivos dentro del directorio: ");
			nombresEnLista.stream()
			.filter(File::isFile)
			.forEach(s -> System.out.println(s.getName()));
		} else
			System.out.println("El archivo pesa " + f.length() + " bytes");
		return true;
	}
	
	public static void recorreDirectorios (File f) {
		List<File> contenidos = Arrays.asList(f.listFiles());
		for (File f2 : contenidos) {
			boolean hayDirectorio = false;
			System.out.println(f2.getName());
			if (f2.isDirectory())
				hayDirectorio = true;
			
		};
	}

	public static void main(String[] args) {
		analiza(new File("C:\\Program Files\\BlueJ"));
	}

}
