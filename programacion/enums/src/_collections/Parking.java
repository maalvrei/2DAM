package _collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Parking {
	
	private String nombre;
	private int totalPlazas;
	private List<Coche> listaDeCoches;
	private static Random random = new Random();
	private Map<Coche, Integer> mapDeCochesIguales;
	private Map<Color, Integer> mapDeColores;
	private Map<Marca, Integer> mapDeMarcas;
	private Set<Coche> setDeCoches;
	
	public Parking(String nombre, int totalPlazas) {
		this.nombre = nombre;
		this.totalPlazas = totalPlazas <= 0 ? 1 : totalPlazas > 10_000 ? 10_000 : totalPlazas;
		listaDeCoches = new ArrayList<>();
		mapDeCochesIguales = new HashMap<>();
		mapDeColores = new HashMap<>();
		mapDeMarcas = new HashMap<>();
		setDeCoches = new HashSet<>();
	}
	
	private boolean estaDentro(Coche coche) {
		for (Coche c: listaDeCoches)
			if(c == coche) return true;
		return false;
	}
	
	private void entraCocheActualizaMapsYSet (Coche c) {
		mapDeMarcas.put(c.getMarca(),
				mapDeMarcas.containsKey(c.getMarca()) ?
						mapDeMarcas.get(c.getMarca()) + 1 : 1);
		mapDeColores.put(c.getColor(),
				mapDeColores.containsKey(c.getColor()) ?
						mapDeColores.get(c.getColor()) + 1 : 1);
		mapDeCochesIguales.put(c,
				mapDeCochesIguales.containsKey(c) ?
						mapDeCochesIguales.get(c) + 1 : 1);
		setDeCoches.add(c);
	}
	
	public boolean entraCoche (Coche c) {
		if (totalPlazas > listaDeCoches.size() && !estaDentro(c)) {
			listaDeCoches.add(c);
			entraCocheActualizaMapsYSet(c);
			return true;
		} else
			return false;
	}
	
	public boolean saleCoche (Coche c) {
		boolean estabaDentro = estaDentro(c);
		if (estabaDentro) {
			listaDeCoches.remove(c);
			saleCocheActualizaMapsYSet(c);
		}
		return estabaDentro;
	}
	
	private void saleCocheActualizaMapsYSet (Coche c) {
		if (mapDeMarcas.get(c.getMarca()) == 1) mapDeMarcas.remove(c.getMarca());
			else mapDeMarcas.put(c.getMarca(), mapDeMarcas.get(c.getMarca()) + 1);
		if (mapDeColores.get(c.getColor()) == 1) mapDeColores.remove(c.getColor());
			else mapDeColores.put(c.getColor(), mapDeColores.get(c.getColor()) + 1);
		if (mapDeCochesIguales.get(c) == 1) mapDeCochesIguales.remove(c);
			else mapDeCochesIguales.put(c, mapDeCochesIguales.get(c) - 1);
		if (listaDeCoches.contains(c)) setDeCoches.remove(c);
	}
	
	public boolean saleCocheAleatorio () {
		return listaDeCoches.isEmpty() ? false : 
			saleCoche(listaDeCoches.get(random.nextInt(listaDeCoches.size())));
	}
	
	public boolean vaciaParking() {
		if(listaDeCoches.isEmpty()) return false;
		else {
			listaDeCoches .clear();
			return true;
		}
	}
	
	public void reportParking() {
		System.out.printf("\nLISTADO DE COCHES\n=================\nParking : %s\n",nombre);
		listaDeCoches.stream().forEach(System.out::println);
		System.out.printf("Total coches: %d Plazas libres: %d\n", listaDeCoches.size(), totalPlazas - listaDeCoches.size() );
	}
	
	public void reportMarcas() {
		System.out.printf("\nLISTADO DE MARCAS\n=================\nParking : %s\n",nombre);
		mapDeMarcas.forEach((k , v) -> System.out.printf("El coche de la marca %s se repite %d veces\n", k.getName(), v));
		System.out.printf("Total coches: %d\n", mapDeMarcas.values().stream().reduce((s , v) -> s + v).orElse(0));
	}
	
	public void reportColores() {
		System.out.printf("\nLISTADO DE COLORES\n=================\nParking : %s\n",nombre);
		mapDeColores.forEach((k , v) -> System.out.printf("El coche del color %s se repite %d veces\n", k.getName(), v));
		System.out.printf("Total coches: %d\n", mapDeColores.values().stream().reduce((s , v) -> s + v).orElse(0));
	}
	
	public void reportCochesIguales() {
		System.out.printf("\nLISTADO DE COCHES IGUALES\n=================\nParking : %s\n",nombre);
		mapDeCochesIguales.forEach((k,v) -> System.out.printf("%s se repite %d vez\n", k, v));
		System.out.printf("Total coches: %d\n",
				mapDeCochesIguales.values().stream().reduce((s , v) -> s + v).orElse(0));
	}
	
	public void reportSetCoches() {
		System.out.printf("\nLISTADO DEL SET DE COCHES\n=================\nParking : %s\n",nombre);
		setDeCoches.stream().sorted((c1,c2) ->c1.getColor().toString().compareTo(c2.getColor().toString()) == 0 ?
				c1.getMarca().toString().compareTo(c2.getMarca().toString()) :
					c1.getColor().toString().compareTo(c2.getColor().toString())).forEach(System.out::println);
		System.out.printf("Total de items: %d \n", setDeCoches.size());
	}
	
}
