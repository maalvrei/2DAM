package collectionsymaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {
	
	public static String[] devuelvePalabras(String cuento) {
		return cuento.trim().replace(".", " ").replace(",", " ").replace("\n", " ").replaceAll(" +", " ").toLowerCase().split(" ");
	}
	
	public static void arrayPalabras(String[] cuento) {
		System.out.println("Array de palabras");
		System.out.println("=================");
		for (String palabra : cuento) {
			System.out.printf("[%s] ", palabra);
		}
		System.out.printf("\nLa lista en array tiene %d palabras\n" , cuento.length);
	}
	
	public static void arrayListPalabras(String[] cuento) {
		System.out.println("Arraylist de palabras");
		System.out.println("=====================");
        List<String> arrayListPalabras = new ArrayList<>(Arrays.asList(cuento));
        for (String palabra : arrayListPalabras) System.out.printf("[%s] ", palabra);
		System.out.printf("\nLa lista en arrayList tiene %d palabras\n" , arrayListPalabras.size());
	}
	
	public static void hashSetPalabras (String[] cuento) {
		System.out.println("HashSet de palabras");
		System.out.println("===================");
		Set<String> set = new HashSet<>(Arrays.asList(cuento));
		for (String palabra : set) System.out.printf("[%s]", palabra);
		System.out.printf("\nLa lista en hashSet tiene %d palabras\n" , set.size());
	}
	
	public static void treeSetPalabras (String[] cuento) {
		System.out.println("TreeSet de palabras");
		System.out.println("===================");
		Set<String> set = new TreeSet<>(Arrays.asList(cuento));
		for (String palabra : set) System.out.printf("[%s]", palabra);
		System.out.printf("\nLa lista en TreeSet tiene %d palabras\n" , set.size());
	}
	
	private static void mapConteoPalabras (String [] cuento) {
		System.out.println("Conteo de repeticiones de palabras");
		System.out.println("==================================");
		Map<String, Integer> map = new HashMap<>();
		for (String palabra : cuento) {
			map.put(palabra, map.containsKey(palabra) ? map.get(palabra) + 1: 1);
		}
		
		for (String palabra : map.keySet()) System.out.printf("[%s(%d)]\n", palabra , map.get(palabra));
		System.out.println(" ");
	}
	
	private static void mapConteoPalabrasOrdenadas (String [] cuento) {
		System.out.println("Conteo de repeticiones de palabras");
		System.out.println("==================================");
		Map<String, Integer> map = new TreeMap<>();
		for (String palabra : cuento) {
			map.put(palabra, map.containsKey(palabra) ? map.get(palabra) + 1: 1);
		}
		
		for (String palabra : map.keySet()) System.out.printf("[%s(%d)]\n", palabra , map.get(palabra));
		System.out.println(" ");
	}
	
	public static void treeSetPalabrasOrdenadasInversa (String[] cuento) {
		System.out.println("TreeSet de palabras ordenadas a la inversa");
		System.out.println("==========================================");
		NavigableSet<String> set = new TreeSet<String>(Arrays.asList(cuento)).descendingSet();
		for (String palabra : set) System.out.printf("[%s]", palabra);
		System.out.printf("\nLa lista en TreeSet ordenado a la inversa tiene %d palabras\n" , set.size());
	}
	
	public static void main(String[] args) {
		// Obtén un String con un cuento sirviéndote de la clase CuentaCuentos.
		String cuento = CuentaCuentos.cuentoLechera();
		//System.out.println("");
		//arrayPalabras(devuelvePalabras(cuento));
		//System.out.println("");
		//arrayListPalabras(devuelvePalabras(cuento));
		//System.out.println("");
		//hashSetPalabras(devuelvePalabras(cuento));
		//System.out.println("");
		//treeSetPalabras(devuelvePalabras(cuento));
		//mapConteoPalabras(devuelvePalabras(cuento));
		// mapConteoPalabrasOrdenadas(devuelvePalabras(cuento));
		//treeSetPalabrasOrdenadasInversa(devuelvePalabras(cuento));
	}
	
}
