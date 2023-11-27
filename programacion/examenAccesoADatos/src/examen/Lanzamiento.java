package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class Lanzamiento {

	private Moneda moneda;
	private Carta carta;
	private int dado1;
	private int dado2;
	Random r = new Random();

	public int getDado1() {
		return dado1;
	}

	public int getDado2() {
		return dado2;
	}

	public Lanzamiento() {
		moneda = Moneda.obtieneMonedaAleatoria();
		carta = new Carta();
		dado1 = r.nextInt(1, 7);
		dado2 = r.nextInt(1, 7);
	}

	public static void main(String[] args) {

		String rutaTxt = "C:\\Users\\José\\Desktop\\repositorio\\2DAM\\programacion\\examenAccesoADatos\\src\\examen\\lanzamientos.txt";

		try (BufferedWriter bw1 = new BufferedWriter(new FileWriter(rutaTxt))) {
			Lanzamiento l = new Lanzamiento();
			boolean lanzamientoInvalido1 = (l.carta.valor != "A" && l.carta.valor != "J" && l.carta.valor != "Q"
					&& l.carta.valor != "K") && (l.dado1 % 2 != 0 || l.dado2 % 2 != 0)
					&& l.moneda.toString().equals("Cruz")
					&& (l.carta.palo == "Treboles" && Integer.valueOf(l.carta.valor) % 2 != 0);
			boolean lanzamientoInvalido2 = (l.getDado1() + l.getDado2() == 7) && (l.moneda.toString().equals("Cara"))
					&& l.carta.esComodin == false;
			int lanzamientosValidos = 0;
			for (int i = lanzamientosValidos; i < 10_000; i++) {
				l = new Lanzamiento();
				if (!lanzamientoInvalido1 && !lanzamientoInvalido2)
					lanzamientosValidos++;
				bw1.append(l.carta.esComodin ? "Comodin|" + l.getDado1() + "|" + l.getDado2() + "|" + l.moneda + "\n"
						: l.carta.valor + "|" + l.carta.palo + "|" + l.getDado1() + "|" + l.getDado2() + "|" + l.moneda
								+ "\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		List<String[]> lineas = new ArrayList<>();

		try (BufferedReader br1 = new BufferedReader(new FileReader(rutaTxt))) {
			String separador = Pattern.quote("|");
			br1.lines().forEach(s -> lineas.add(s.split(separador)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String rutaSQL = "C:\\Users\\José\\Desktop\\repositorio\\2DAM\\programacion\\examenAccesoADatos\\src\\examen\\lanzamientossql.txt";

		try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(rutaSQL))) {
			int lineasValidasSql = 0;
			for (int i = lineas.size() - 1; i > 0; i--) {
				String[] linea = lineas.get(i);
				if ((linea[1].equals("Corazones") || linea[1].equals("Picas")) && lineasValidasSql == 0) {
					bw2.append(String.format(
							"INSER INTO lanzamientos ('Numero de la carta' , 'Palo', 'Dado 1', 'Dado 2', 'Moneda') VALUES ('%s','%s','%s','%s','%s'),%n",
							linea[0], linea[1], linea[2], linea[3], linea[4]));
					lineasValidasSql += 1;
				} else if ((linea[1].equals("Corazones") || linea[1].equals("Picas")) && (lineasValidasSql < 200)) {
					bw2.append(String.format("('%s','%s','%s','%s','%s'),%n", linea[0], linea[1], linea[2], linea[3],
							linea[4]));
					lineasValidasSql += 1;
				} else if ((linea[1].equals("Corazones") || linea[1].equals("Picas")) && (lineasValidasSql == 200)) {
					bw2.append(String.format("('%s','%s','%s','%s','%s');%n", linea[0], linea[1], linea[2], linea[3],
							linea[4]));
					lineasValidasSql += 1;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		String rutaHtml = "C:\\Users\\José\\Desktop\\repositorio\\2DAM\\programacion\\examenAccesoADatos\\src\\examen\\lanzamientoshtml.html";

		try (BufferedWriter bw3 = new BufferedWriter(new FileWriter(rutaHtml))) {
			int lineasValidasHtml = 0;
			bw3.append(
					"<table><tr><th>Numero de Carta</th><th>Palo</th><th>Dado 1</th><th>Dado 2</th><th>Moneda</th></tr>");
			for (int i = lineas.size() - 1; i > 0; i--) {
				String[] linea = lineas.get(i);
				if ((linea[1].equals("Corazones") || linea[1].equals("Picas")) && (lineasValidasHtml < 200)) {
					bw3.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
							linea[0], linea[1], linea[2], linea[3], linea[4]));
					lineasValidasHtml += 1;
				}
			}
			
			bw3.append("</table>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
