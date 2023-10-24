package funcintlambdas;

import java.util.ArrayList;
import java.util.List;

public class MetodoConIF {

	/*private List<Integer> filtra (List<Integer> lista, IFfiltroEnteros filtro) {
		ArrayList<Integer> listaFiltrada = new ArrayList<Integer>();
		
		for (int i : lista) {
			if (filtro.opera(i))
				listaFiltrada.add(i);
		}
		
		return lista;
	}*/
	
	private static List<Integer> filtra(List<Integer> listaOriginal, IFfiltroEnteros filtro) {
		List<Integer>  listaFinal = new ArrayList<Integer>();
		for (Integer i : listaOriginal)
			if (filtro.opera(i)) listaFinal.add(i);
		return listaFinal;
	}
	
	public static void main(String[] args) {
		IFfiltroEnteros mayorEdad = x -> x > 18;
		IFfiltroEnteros menorEdad = x -> x < 18;
		
		ArrayList<Integer>  lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(4);
		lista.add(8);
		lista.add(78);
		System.out.println(filtra(lista,mayorEdad));
	}

}
