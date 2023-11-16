package collectionsymaps;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo {

	public static void main(String[] args) {
		
		List<Character> lista = new ArrayList<>();
		for (int i = 'A' ; i <= 'z' ; i++) {
			lista.add((char)i);
		}
		
		lista.stream().forEach(System.out::println);
		
	}
	
}
