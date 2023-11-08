package directorio;

import java.io.File;

public class PruebaConFile {
	
	public static void main(String[] args) {
		File f1 = new File("C:\\Program Files\\Adobe");
		System.out.println(f1.getParent());
		System.out.println(f1.getParentFile());
	}
	
}
