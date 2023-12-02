package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

	public static void escribeTXT(String ruta) {

		File f = new File(ruta, "lanzamientos.txt");
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(f))) {

			Predicate<Lanzamiento> dadoPar = l -> l.dado1 % 2 == 0 && l.dado2 % 2 == 0;

			Predicate<Lanzamiento> monedaNoEsCruz = l -> !l.moneda.equals("Cruz");

			Predicate<Lanzamiento> cartaNoEsTrebolImpar = l -> {
				Carta c = l.carta;
				boolean esImpar = false;
				if (!(c.valor.equals("A") || c.valor.equals("J") || c.valor.equals("Q") || c.valor.equals("K") || c.valor.equals("0")))
					esImpar = Integer.valueOf(c.valor)%2 != 0 ;
				return !c.palo.equals("Treboles") || esImpar == false;
			};
			
			Predicate<Lanzamiento> lanzamientoValido = dadoPar.negate().or(monedaNoEsCruz).or(cartaNoEsTrebolImpar);
			
			int lanzamientosValidos = 0;
			for (int i = 0; i < 10_000; i++) {
				Lanzamiento l = new Lanzamiento();
				if (lanzamientoValido.test(l)) {
					lanzamientosValidos++;
					bw1.append(
							l.carta.valor + "|" + l.carta.palo + "|" + l.dado1 + "|" + l.dado2 + "|" + l.moneda + "\n");
				} else
					System.out.println(l);
			}
			System.out.printf("Se han escrito %d lanzamientos", lanzamientosValidos);
		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<String[]> leeTXT(String ruta) {
		List<String[]> lineas = new ArrayList<>();

		try (BufferedReader br1 = new BufferedReader(new FileReader(ruta))) {
			String separador = Pattern.quote("|");
			br1.lines().forEach(s -> lineas.add(s.split(separador)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lineas;
	}

	public static void escribeSQL(String ruta, List<String[]> lineas) {

		File f = new File(ruta, "sentencias.sql");
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(f))) {
			int sentenciasCreadas = 0;
			for (int i = lineas.size() - 1; i > 0; i--) {
				String[] linea = lineas.get(i);
				boolean lineaValida = (linea[1].equals("Corazones") || linea[1].equals("Picas"));
				if (lineaValida && sentenciasCreadas == 0) {
					bw2.append(String.format(
							"INSER INTO lanzamientos ('Numero de la carta' , 'Palo', 'Dado 1', 'Dado 2', 'Moneda') VALUES ('%s','%s','%s','%s','%s'),%n",
							linea[0], linea[1], linea[2], linea[3], linea[4]));
					sentenciasCreadas += 1;
				} else if (lineaValida && sentenciasCreadas < 200) {
					bw2.append(String.format("('%s','%s','%s','%s','%s'),%n", linea[0], linea[1], linea[2], linea[3],
							linea[4]));
					sentenciasCreadas += 1;
				} else if (lineaValida && sentenciasCreadas == 200) {
					bw2.append(String.format("('%s','%s','%s','%s','%s');%n", linea[0], linea[1], linea[2], linea[3],
							linea[4]));
					sentenciasCreadas += 1;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void escribeHTML(String ruta, List<String[]> lineas) {

		File f = new File(ruta, "tablaLanzamientos.html");
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		try (BufferedWriter bw3 = new BufferedWriter(new FileWriter(f))) {
			int filasCreadas = 0;
			bw3.append(
					"<table><tr><th>Numero de Carta</th><th>Palo</th><th>Dado 1</th><th>Dado 2</th><th>Moneda</th></tr>");
			for (int i = lineas.size() - 1; i > 0; i--) {
				String[] linea = lineas.get(i);
				boolean lineaValida = (linea[1].equals("Corazones") || linea[1].equals("Picas"));
				if (lineaValida && filasCreadas < 200) {
					bw3.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
							linea[0], linea[1], linea[2], linea[3], linea[4]));
					filasCreadas += 1;
				}
			}
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

		String rutaTxt = "C:\\Users\\migue\\Desktop\\repo 2º dam\\2DAM\\programacion\\examenAccesoADatos\\src\\examen\\";
		escribeTXT(rutaTxt);
		String rutaSQL = "C:\\Users\\migue\\Desktop\\repo 2º dam\\2DAM\\programacion\\examenAccesoADatos\\src\\examen\\";
		List<String[]> lineas = leeTXT(rutaTxt + "lanzamientos.txt");
		escribeSQL(rutaSQL, lineas);
		String rutaHtml = "C:\\Users\\migue\\Desktop\\repo 2º dam\\2DAM\\programacion\\examenAccesoADatos\\src\\examen\\";
		escribeHTML(rutaHtml, lineas);

	}
}
