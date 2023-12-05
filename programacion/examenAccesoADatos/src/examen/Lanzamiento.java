package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Lanzamiento {

	private String moneda;
	private Carta carta;
	private int dado1;
	private int dado2;
	Random r = new Random();

	public Lanzamiento() {
		moneda = r.nextBoolean() ? "Cara" : "Cruz";
		carta = Carta.cartaAleatoriaDeLaBaraja();
		dado1 = r.nextInt(1, 7);
		dado2 = r.nextInt(1, 7);
	}

	/*el constructor con los parametros es el que se usa en el metodo generaLanzamientoDeUnaLinea*/
	
	public Lanzamiento(Carta carta, int dado1, int dado2, String moneda) {
		this.moneda = moneda;
		this.carta = carta;
		this.dado1 = dado1;
		this.dado2 = dado2;
	}

	/* este metodo verifica que el file que vamos a utilizar para ser leido o escrito existe y si no existe lo crea*/
	
	private static File creaArchivoSiNoExiste (String ruta, String nombreArchivo) {
		File f = new File(ruta, nombreArchivo);
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return f;
	}
	
	/*metodo utilizado en la escritura para validar que el lanzamiento es el correcto y que no se corresponde
	 * con lo descrito para un lanzamiento erroneo*/

	private static boolean validaConPredicates(Lanzamiento lanzamiento) {

		Predicate<Lanzamiento> dadoImparCruzTreboles = l -> (l.dado1 % 2 != 0 || l.dado2 % 2 != 0)
				&& (l.moneda.equals("Cruz")) && l.carta.palo.equals("Treboles");
		Predicate<Lanzamiento> cartaImpar = l -> {
			Carta c = l.carta;
			boolean esImpar = false;
			if (!(c.valor.equals("A") || c.valor.equals("0") || c.valor.equals("J") || c.valor.equals("Q")
					|| c.valor.equals("K")))
				if (Integer.valueOf(c.valor) % 2 != 0)
					esImpar = true;
			return esImpar;
		};
		Predicate<Lanzamiento> lanzamientoInvalido1 = dadoImparCruzTreboles.and(cartaImpar);
		Predicate<Lanzamiento> lanzamientoInvalido2 = l -> (l.dado1 + l.dado2 == 7)
				&& (l.moneda.equals("Cara") && (l.carta.palo.equals("Treboles") || l.carta.palo.equals("Corazones")
						|| l.carta.palo.equals("Diamantes") || l.carta.palo.equals("Picas")));
		Predicate<Lanzamiento> lanzamientosInvalidos = lanzamientoInvalido1.or(lanzamientoInvalido2);
		return lanzamientosInvalidos.negate().test(lanzamiento);
	}

	/* por simplificar un poco el metodo de escritura en el txt, cree este metodo auxiliar que general
	 * cada linea del txt con los datos del lanzamiento separados por el palito*/
	
	private static String generaLineaParaElTxt (Lanzamiento l) {
		 return l.carta.valor + "|" + l.carta.palo + "|" + l.dado1 + "|" + l.dado2 + "|" + l.moneda + "\n";
	}
	
	/*el metodo escribeTXT escribe en el txt aquellos lanzamientos que sean validos en un rango de 10_000 lanzaminetos*/
	
	public static void escribeTXT(String ruta) {

		File f = creaArchivoSiNoExiste(ruta, "lanzamientos.txt");

		try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(f))) {
			for (int i = 0; i < 10_000; i++) {
				Lanzamiento l = new Lanzamiento();
				if (validaConPredicates(l))
					bw1.append(
							generaLineaParaElTxt(l));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*metodo utilizado en la lectura del txt para crear un nuevo lanzamiento de cada linea del text*/
	private static Lanzamiento generaLanzamientoDeUnaLinea(String[] linea) {
		Carta c = new Carta(linea[0], linea[1]);
		int dado1 = Integer.valueOf(linea[2]);
		int dado2 = Integer.valueOf(linea[3]);
		String moneda = linea[4];
		return new Lanzamiento(c, dado1, dado2, moneda);
	}
	
	/*el metodo leeTXT lo que hace es leer el documento y devolver un list de objetos lanzamientos*/
	
	public static List<Lanzamiento> leeTXT(String ruta) {
		File f = new File(ruta, "lanzamientos.txt");
		List<Lanzamiento> lanzamientos = new ArrayList<>();
		try (BufferedReader br1 = new BufferedReader(new FileReader(f))) {
			String separador = Pattern.quote("|");
			br1.lines().forEach(linea -> {
				/*como el metodo lines de los bf reader devuelve todas las lineas del archivo leido en forma de String,
				 * aprovechamos que cada linea la podemos convertir en un array de String haciendo split para pasarsela al metodo 
				 * generaLanzamentoDeUnaLinea y que este cree el lanzamiento con los datos de esa linea */
				Lanzamiento l = generaLanzamientoDeUnaLinea(linea.split(separador));
				lanzamientos.add(l);
			});
		} catch (Exception e) {
			System.out.println("No se puede leer un txt que no existe.");
		}
		return lanzamientos;
	}

	/*el metodo escribeSQL verifica si existe o no el archivo .sql y crea las 200 sentencias de insercion en bbdd
	 * con las ultimas 200 tiradas q fueron validas
	 * se da por sentado que la tabla y la bbdd ya existen ya que en el enunciado del ejercicio
	 *  se habla solo de las sentencias de insercion
	 * no de creacion de la bbdd ni de la tabla
	 * por conveccion en bases de datos, los nombres de las columnas se da por sentado igualmente que estan escritos como
	 * numero_carta, palo_carta, etcc....*/
	
	public static void escribeSQL(String ruta, List<Lanzamiento> lanzamientos) {

		File f = creaArchivoSiNoExiste(ruta, "sentencias.sql");

		try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(f))) {
			Collections.reverse(lanzamientos);
			lanzamientos.stream().filter(l -> l.carta.palo.equals("Corazones") || l.carta.palo.equals("Picas"))
					.limit(200).forEach(l -> {
						try {
							bw2.append(String.format(
									"INSERT INTO lanzamientos ('numero_carta' , 'palo_carta', 'dado1', 'dado2', 'moneda') VALUES ('%s','%s','%s','%s','%s');%n",
									l.carta.valor, l.carta.palo, l.dado1, l.dado2, l.moneda));
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/*el metodo escribehtml crea la tabla con las ultimas 200 tiradas que fueron validas.
	 * no se crea la cabecera del documento html ni demas estructuras semanticas como header, body, etc...
	 * por no hacer el ejercicio mas enrrevesado, pero seria tan sencillo como hacer un bw3.append y añadirla
	 * en forma de String... si quieres que lo cree dimelo javi y te lo modifico en un santiamen */
	
	public static void escribeHTML(String ruta, List<Lanzamiento> lanzamientos) {

		File f = creaArchivoSiNoExiste(ruta, "tablaLanzamientos.html");
		
		try (BufferedWriter bw3 = new BufferedWriter(new FileWriter(f))) {
			Collections.reverse(lanzamientos);
			bw3.append(
					"<table><tr><th>Numero de Carta</th><th>Palo</th><th>Dado 1</th><th>Dado 2</th><th>Moneda</th></tr>");
			lanzamientos.stream().filter(l -> l.carta.palo.equals("Corazones") || l.carta.palo.equals("Picas"))
					.limit(200).forEach(l -> {
						try {
							bw3.append(
									(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
											l.carta.valor, l.carta.palo, l.dado1, l.dado2, l.moneda)));
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
			bw3.append("</table>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		/**/
		
		String ruta = "C:\\Users\\Usuario\\Desktop";
		//escribeTXT(ruta);
		List<Lanzamiento> lanzamientos = leeTXT(ruta);
		//escribeSQL(ruta, lanzamientos);
		//escribeHTML(ruta, lanzamientos);

	}
}
