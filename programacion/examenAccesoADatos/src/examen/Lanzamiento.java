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

	public Lanzamiento(Carta carta, int dado1, int dado2, String moneda) {
		this.moneda = moneda;
		this.carta = carta;
		this.dado1 = dado1;
		this.dado2 = dado2;
	}

	private static Lanzamiento generaLanzamientoDeUnaLinea(String[] linea) {
		Carta c = new Carta(linea[0], linea[1]);
		int dado1 = Integer.valueOf(linea[2]);
		int dado2 = Integer.valueOf(linea[3]);
		String moneda = linea[4];
		return new Lanzamiento(c, dado1, dado2, moneda);
	}

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

	public static void escribeTXT(String ruta) {

		File f = new File(ruta, "lanzamientos.txt");
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(f))) {
			for (int i = 0; i < 10_000; i++) {
				Lanzamiento l = new Lanzamiento();
				if (validaConPredicates(l))
					bw1.append(
							l.carta.valor + "|" + l.carta.palo + "|" + l.dado1 + "|" + l.dado2 + "|" + l.moneda + "\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<Lanzamiento> leeTXT(String ruta) {
		File f = new File(ruta, "lanzamientos.txt");
		List<Lanzamiento> lanzamientos = new ArrayList<>();
		try (BufferedReader br1 = new BufferedReader(new FileReader(f))) {
			String separador = Pattern.quote("|");
			br1.lines().forEach(linea -> {
				Lanzamiento l = generaLanzamientoDeUnaLinea(linea.split(separador));
				lanzamientos.add(l);
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lanzamientos;
	}

	public static void escribeSQL(String ruta, List<Lanzamiento> lanzamientos) {

		File f = new File(ruta, "sentencias.sql");
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(f))) {
			Collections.reverse(lanzamientos);
			lanzamientos.stream().filter(l -> l.carta.palo.equals("Corazones") || l.carta.palo.equals("Picas"))
					.limit(200).forEach(l -> {
						try {
							bw2.append(String.format(
									"INSER INTO lanzamientos ('Numero de la carta' , 'Palo', 'Dado 1', 'Dado 2', 'Moneda') VALUES ('%s','%s','%s','%s','%s');%n",
									l.carta.valor, l.carta.palo, l.dado1, l.dado2, l.moneda));
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void escribeHTML(String ruta, List<Lanzamiento> lanzamientos) {

		File f = new File(ruta, "tablaLanzamientos.html");
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

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

	@Override
	public String toString() {
		return String.format("Lanzamiento con moneda %s, dado 1 %d, dado 2 %d, y carta %s %s%n", moneda, dado1, dado2,
				carta.palo, carta.valor);
	}

	public static void main(String[] args) {

		String ruta = "C:\\Users\\migue\\Desktop\\repo 2º dam\\2DAM\\programacion\\examenAccesoADatos\\src\\examen\\";
		escribeTXT(ruta);
		List<Lanzamiento> lanzamientos = leeTXT(ruta);
		escribeSQL(ruta, lanzamientos);
		escribeHTML(ruta, lanzamientos);

	}
}
