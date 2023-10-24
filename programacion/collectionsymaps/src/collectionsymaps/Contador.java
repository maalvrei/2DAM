package collectionsymaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Contador implements Comparable<Contador> {

	private int valor;
	private String modelo;

	public Contador(int valor, String modelo) {
		this.valor = valor;
		this.modelo = modelo;
	}

	/*
	 * @Override Para comparar por valor public int compareTo(Contador o) { return
	 * valor - o.valor;
	 * 
	 * }
	 */

	@Override
	// Para comparar alfabeticamente por modelo
	public int compareTo(Contador o) {
		return modelo.compareTo(o.modelo);

	}

	@Override
	public String toString() {
		return "Contador [valor= " + valor + ", modelo= " + modelo + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contador other = (Contador) obj;
		return Objects.equals(modelo, other.modelo) && valor == other.valor;
	}

	public static void main(String[] args) {

		List<Contador> listaDeContadores = new ArrayList<>();

		listaDeContadores.add(new Contador(100, "Modelo A"));
		listaDeContadores.add(new Contador(200, "Modelo B"));
		listaDeContadores.add(new Contador(300, "Modelo C"));
		listaDeContadores.add(new Contador(400, "Modelo D"));
		listaDeContadores.add(new Contador(500, "Modelo B"));
		listaDeContadores.add(new Contador(100, "Modelo F"));
		listaDeContadores.add(new Contador(200, "Modelo G"));
		listaDeContadores.add(new Contador(600, "Modelo H"));
		listaDeContadores.add(new Contador(200, "Modelo B"));
		listaDeContadores.add(new Contador(100, "Modelo A"));

		System.out.println("Ordenados en el arrayList\n==========================");

		Collections.sort(listaDeContadores);

		for (Contador c : listaDeContadores) {
			System.out.println(c);
		}

		System.out.println("\nOrdenados en el hashSet\n==========================");
		
		System.out.println(listaDeContadores.size());
		
		Set<Contador> set = new HashSet<>();
		
		for (Contador c : listaDeContadores) {
			set.add(c);
		}
		
		for (Contador c : set) {
			System.out.println(c);
		}
		
		System.out.println(set.size());
		System.out.println(new Contador(100, "Modelo A").equals(new Contador(1000, "Modelo A")));
	}

}
