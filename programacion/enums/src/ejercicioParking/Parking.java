package ejercicioParking;

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
	private Map<Color, Integer> mapDeColores;
	private Map<Marca, Integer> mapDeMarcas;
	private Map<Coche, Integer> mapDeCochesIguales;
	private Set<Coche> setDeCoches;

	public Parking(String nombre, int totalPlazas) {
		this.nombre = nombre;
		this.totalPlazas = totalPlazas;
		listaDeCoches = new ArrayList<>();
		mapDeColores = new HashMap<>();
		mapDeMarcas = new HashMap<>();
		mapDeCochesIguales = new HashMap<>();
		setDeCoches = new HashSet<>();
	}
	
	// el metodo estaEnElParking devuelve si la lista contiene o no el coche. el metodo equals
	// de la clase coche está pensado para que puedan entrar coches iguales que otros coches sin ser el mismo objeto

	boolean estaEnElParking(Coche c) {
		return listaDeCoches.contains(c);
	}

	// hay sitio en el parking devuelve true si la lista de coches es menor que las plazas
	// y false si la lista es mayor que las plazas
	
	boolean haySitioEnElParking() {
		return listaDeCoches.size() < totalPlazas;
	}

	// el metodo añadeMapDeColores mapea el map de colores si hay alguna key que se corresponda con el color que entra
	// si la key no existe, la crea y le introduce valor inicial 1
	// si existe, suma en 1 el value asociado a esa key
	
	private void añadeMapDeColores(Color c) {
		if (mapDeColores.containsKey(c))
			mapDeColores.put(c, mapDeColores.get(c) + 1);
		else
			mapDeColores.put(c, 1);
	}
	
	// el metodo añadeMapDeMarcas mapea el map de marcas para ver si hay alguna key que se corresponda con el color que entra
	// si la key no existe, la crea y le introduce valor inicial 1
	// si existe, suma en 1 el value asociado a esa key

	private void añadeMapDeMarcas(Marca m) {
		if (mapDeMarcas.containsKey(m))
			mapDeMarcas.put(m, mapDeMarcas.get(m) + 1);
		else
			mapDeMarcas.put(m, 1);
	}

	// el metodo añadeMapDeCochesIguales mapea el map de coches iguales para ver si hay algun coche igual en marca y color al que entra
	// para poder manejar el valor de la key cuando un coche que entra tiene el mismo modelo y marca que el que ya está en el map
	// se crea una variable Coche llamada cocheQueEsIgual, para obtener la posicion key del map que debemos modificar.
	// está el problema de que cuando añadimos un coche que es igual en marca y color pero que es otro objeto diferente, este se añade al map
	// como una nueva key. no sabia gestionar eso y por ello que recorrido las keys del map, para ver si alguna tiene el mismo modelo y color
	// que el coche que entra. si se encuentra un coche igual en modelo y marca, la variable cocheQueEsIgual, que antes era null, apuntara 
	// a la posicion de memoria que corresponde a la su key del map y la booleana hayUnCocheIgual, será true.
	// así, si hayUnCocheIgual es true, se añadira a la posicion del map donde esta el CocheQueEsIgual, su value + 1
	// en caso contrario, se crea una nueva key con valor inicial 1
	
	void añadeMapDeCochesIguales(Coche cocheQueEntra) {
		Coche cocheQueEsIgual = null;
		boolean hayUnCocheIgual = false;
		for (Coche cocheEnElMap : mapDeCochesIguales.keySet()) {
			if (cocheEnElMap.color == cocheQueEntra.color && cocheEnElMap.marca == cocheQueEntra.marca) {
				cocheQueEsIgual = cocheEnElMap;
				hayUnCocheIgual = true;
			}
		}
		if (hayUnCocheIgual)
			mapDeCochesIguales.put(cocheQueEsIgual, mapDeCochesIguales.get(cocheQueEsIgual) + 1);
		else
			mapDeCochesIguales.put(cocheQueEntra, 1);
	}
	
	// igual que con el mapDeCochesIguales, tenemos el problema de que cuando añadimos un nuevo coche, de color y marca igual
	// a otro que ya esté en el parking, se añadirá de todas maneras al set, ya que son objetos diferentes. por ello, recorro el set
	// para ello, creo una booleana hayCocheIgual que por defecto es false, y solo será true si hay un coche de igual marca y color en el set
	// si es false, es decir, no hay coches del mismo modelo y marca, el coche se añade al set.
	
	void añadeSetDeCoches (Coche cocheQueEntra) {
		boolean hayCocheIgual = false;
		for (Coche cocheEnElSet : setDeCoches)
			if (cocheEnElSet.marca == cocheQueEntra.marca && cocheEnElSet.color == cocheQueEntra.color)
				hayCocheIgual = true;
		if (hayCocheIgual == false)
			setDeCoches.add(cocheQueEntra);
	}
	
	// mientras haya coches del mismo modelo y marca en la lista, no deben desaparecer del set. pero como el set no lleva asociado ninguna cantidad
	// debemos comprobar, antes de eliminar el coche del set, que en la lista ya no queden coches de esa marca y color. por ello, se crea una variable
	// de tipo entero, llamada cochesIguales, con valor a 0. se recorre la lista, y por cada coche que se encuentre con esa marca y color se suma 1 
	// a la variable int. si hay 1 o menos coches iguales a ese en la lista, se elimina del set.
	
	void eliminaSetDeCoches (Coche c) {
		int cochesIguales = 0;
		for (Coche cocheEnLaLista : listaDeCoches) {
			if (cocheEnLaLista.marca == c.marca && cocheEnLaLista.color == c.color) {
				cochesIguales++;
			}
		}
		if(cochesIguales <= 1 )
			setDeCoches.remove(c);
	}
	
	// igual que en el metodo añadeMapDeCochesIguales, se recorren las keys del map para ver cual de ellas corresponde con un coche de la misma
	// marca y modelo. una vez se detecta, si su valor es de 1, se elimina del map y se pierde la entrada, ya que no puede haber values a 0
	// y si es de mas de 1, se resta 1, para no perder la entrada.
	
	void eliminaMapDeCochesIguales(Coche cocheQueSale) {
		Coche cocheQueEsIgual = null;
		for (Coche cocheEnElMap : mapDeCochesIguales.keySet()) {
			if (cocheEnElMap.color == cocheQueSale.color && cocheEnElMap.marca == cocheQueSale.marca) {
				cocheQueEsIgual = cocheEnElMap;
			}
		}
		if (mapDeCochesIguales.get(cocheQueEsIgual) == 1)
			mapDeCochesIguales.remove(cocheQueEsIgual);
		else
			mapDeCochesIguales.put(cocheQueEsIgual, mapDeCochesIguales.get(cocheQueEsIgual) - 1);
	}

	// se accede al valor de la key que se corresponde con ese color. si solo hay 1 coche rojo, por ejemplo, se elimina la entrada. si hay 2, por ejemplo
	// se resta 1 a ese valor
	
	void eliminaMapDeColores(Color c) {
		if (mapDeColores.get(c) == 1)
			mapDeColores.remove(c);
		else
			mapDeColores.put(c, mapDeColores.get(c) - 1);
	}
	
	// se accede al valor de la key que se corresponde con esa marca. si solo hay 1 coche rojo, por ejemplo, se elimina la entrada. si hay 2, por ejemplo
	// se resta 1 a ese valor

	void eliminaMapDeMarcas(Marca m) {
		if (mapDeMarcas.get(m) == 1)
			mapDeMarcas.remove(m);
		else
			mapDeMarcas.put(m, mapDeMarcas.get(m) - 1);
	}
	
	// este metodo llama a los anteriores. si el coche no esta en la lista, es decir, estaEnElParking es false, y si haySitioEnElParking es true
	// se añade a la lista y se llama a los demás métodos para que hagan su trabajo

	boolean entraCoche(Coche c) {
		if (!estaEnElParking(c) && haySitioEnElParking()) {
			listaDeCoches.add(c);
			añadeMapDeColores(c.color);
			añadeMapDeMarcas(c.marca);
			añadeMapDeCochesIguales(c);
			añadeSetDeCoches(c);
		}
		return estaEnElParking(c);
	}
	
	// lo mismo que con entra coche. Si estaEnElParking es true, se elimina del parking.

	boolean saleCoche(Coche c) {
		if (estaEnElParking(c)) {
			listaDeCoches.remove(c);
			eliminaMapDeColores(c.color);
			eliminaMapDeMarcas(c.marca);
			eliminaMapDeCochesIguales(c);
			eliminaSetDeCoches(c);
			return true;
		} else
			return false;
	}
	
	// se vacia la lista y los map y el set

	boolean vaciaParking() {
		if (!listaDeCoches.isEmpty()) {
			for (int i = listaDeCoches.size() - 1; i >= 0; i--) {
				System.out.println("Borrado " + listaDeCoches.get(i).toString());
				listaDeCoches.remove(i);
			}
			mapDeColores.clear();
			mapDeMarcas.clear();
			mapDeCochesIguales.clear();
			setDeCoches.clear();
			return true;
		} else
			return false;
	}

	// igual que saleCoche, pero se elige uno aleatorio de la lista, con una posicion aleatoria de la misma con random next int
	
	boolean saleCocheAleatrorio() {
		if (!listaDeCoches.isEmpty()) {
			Coche cocheAEliminar = listaDeCoches.get(new Random().nextInt(0, listaDeCoches.size()));
			listaDeCoches.remove(cocheAEliminar);
			eliminaMapDeColores(cocheAEliminar.color);
			eliminaMapDeMarcas(cocheAEliminar.marca);
			eliminaMapDeCochesIguales(cocheAEliminar);
			eliminaSetDeCoches(cocheAEliminar);
			return true;
		} else
			return false;
	}

	// metodo de printado del arrayList listaDeCoches
	
	void reportParking() {
		System.out.printf("\nLISTADO COCHES\n==============\nParking: %s\n", nombre);
		listaDeCoches.stream().forEach(s -> System.out.println(s.toString()));
		System.out.printf("\nTotal coches : %d  Plazas libres: %d", listaDeCoches.size(),
				totalPlazas - listaDeCoches.size());
	}

	// metodo de printado del map de colores iguales
	
	void reportColores() {
		System.out.printf("\nLISTADO COLORES\n==============\nParking: %s\n", nombre);
		int sumaTotalVehiculos = mapDeColores.values().stream().toList().stream().mapToInt(Integer::intValue).sum();
		mapDeColores.keySet().stream().forEach(s -> System.out.printf("El coche de color %s aparece %d %s\n",
				s.toString(), mapDeColores.get(s), mapDeColores.get(s) == 1 ? "vez" : "veces"));

		System.out.printf("\nTotal de vehiculos: %d\n", sumaTotalVehiculos);
	}
	
	// metodo de printado del map de marcas iguales

	void reportMarcas() {
		System.out.printf("\nLISTADO MARCAS\n==============\nParking: %s\n", nombre);
		int sumaTotalVehiculos = mapDeMarcas.values().stream().toList().stream().mapToInt(Integer::intValue).sum();
		mapDeMarcas.keySet().stream().forEach(s -> System.out.printf("El coche de marca %s aparece %d %s\n",
				s.toString(), mapDeMarcas.get(s), mapDeMarcas.get(s) == 1 ? "vez" : "veces"));

		System.out.printf("\nTotal de vehiculos: %d\n", sumaTotalVehiculos);
	}

	// metodo de printado del map de coches iguales
	
	void reportCochesIguales() {
		System.out.printf("\nLISTADO COCHES IGUALES\n==============\nParking: %s\n", nombre);
		int sumaTotalVehiculos = mapDeCochesIguales.values().stream().toList().stream().mapToInt(Integer::intValue)
				.sum();
		mapDeCochesIguales.keySet().stream()
				.forEach(s -> System.out.printf("%s - %d\n", s.toString(), mapDeCochesIguales.get(s)));
		System.out.printf("\nTotal de vehiculos: %d\n", sumaTotalVehiculos);
	}
	
	// metodo de printado del set de coches
	
	void reporSetCoches() {
		System.out.println("\nREPOR SET DE COCHES\n================\n");
		setDeCoches.stream().forEach(s -> System.out.printf("[%s]\n", s.toString()));
	}

	public static void main(String[] args) {

		// se crea un parking de nombre parking de miguelito con 100 plazas
		
		Parking p1 = new Parking("Parking Miguelito", 100);
		
		//se crean 6 nuevos coches. los 4 primeros son diferentes y el 5 y el 6 son iguales entre ellos
		
		Coche c1 = new Coche(Marca.AU, Color.AM);
		Coche c2 = new Coche(Marca.CH, Color.IN);
		Coche c3 = new Coche(Marca.HO, Color.NA);
		Coche c4 = new Coche(Marca.TO, Color.RO);
		Coche c5 = new Coche(Marca.VW, Color.VI);
		Coche c6 = new Coche(Marca.VW, Color.VI);

		p1.entraCoche(c1);
		p1.entraCoche(c2);
		p1.entraCoche(c3);
		p1.entraCoche(c4);
		p1.entraCoche(c5);
		p1.entraCoche(c6);
		
		// se comprueba que los colores están bien introducidos en su map, debe haber uno amarillo, uno indigo, uno naranja, uno rojo y dos violetas
		p1.reportColores();
		// se comprueba que las marcas están bien introducidas en su map, debe haber un audi, un chevrolet, un honda, un toyota y dos volkswagen
		p1.reportMarcas();
		//se comprueban los coches iguales. debe haber un honda naranja, un toyota rojo, un audi amarillo, un chevrolet indigo y dos volkwagen violetas
		p1.reportCochesIguales();
		// se comprueba el set. debe haber solo un coche de cada clase, por lo que el volkswagen violeta solo debe imprimirse una vez
		p1.reporSetCoches();
		p1.saleCoche(c6);
		// se saca el coche 6 para ver si los colores, marcas, coches iguales y el set se alteran correctamente
		System.out.println("\nYA HA SALIDO EL COCHE 6\n");
		// en el set debe seguir apareciendo que hay un coche volkswagen violeta, ya que c5 sigue en el parking
		p1.reporSetCoches();
		//en el listado de coches iguales, volkswagen violeta debe haber cambiado su valor a 1
		p1.reportCochesIguales();
		// en el listado de marcas, solo aparece un volkswagen
		p1.reportMarcas();
		// en el listado de colores, solo aparece un coche violeta
		p1.reportColores();
		//se saca el coche 5 para ver que ya no hay coche violeta y volkwagen en el set y que el violeta y la marca volkwagen desaparecen
		//de sus correspondientes maps
		p1.saleCoche(c5);
		System.out.println("\nYA HA SALIDO EL COCHE 5\n");
		p1.reporSetCoches();
		// en el set de coches ya no aparece ningun volkswagen violeta
		p1.reportMarcas();
		// en las marcas ya no hay volkswagen
		p1.reportCochesIguales();
		//en los coches iguales ya no hay volkswagen violeta tampoco
		p1.saleCocheAleatrorio();
		// podemos tambien sacar coches aleatorios sin problema para ver como van cambiando los maps y el set aleatoriamente
		p1.vaciaParking();
		p1.reportParking();
		p1.reporSetCoches();
		p1.reportCochesIguales();
		p1.reportColores();
		p1.reportMarcas();
		// y si vaciamos el parking los metodos de printado no imprimen nada
	}

}
