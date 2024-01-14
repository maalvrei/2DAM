package sentenciasPreguntas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LeePreguntas {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\migue\\Desktop\\pcp.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bfr = new BufferedReader(fr);
		List<String> listaDePreguntas = new ArrayList<>();
		bfr.lines().forEach(s -> listaDePreguntas.add(s));
		listaDePreguntas.stream().forEach(System.out::println);

		File f2 = new File("C:\\Users\\migue\\Desktop\\import.sql");
		FileWriter fw = null;
		try {
			fw = new FileWriter(f2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedWriter bfw = new BufferedWriter(fw);
		listaDePreguntas.stream().forEach(s -> {
			String separador = Pattern.quote("|");
			String[] arrayConLaPregunta = s.split(separador);
			String tipoDePregunta = arrayConLaPregunta[0];
			String enunciado = arrayConLaPregunta[1];
			String respuestaCorrecta = arrayConLaPregunta[2];
			String respuesta1 = null;
			String respuesta2 = null;
			String respuesta3 = null;
			String respuesta4 = null;
			if (tipoDePregunta.equals("2")) {
				respuesta1 = arrayConLaPregunta[2];
				respuesta2 = arrayConLaPregunta[3];
				respuesta3 = arrayConLaPregunta[4];
				respuesta4 = arrayConLaPregunta[5];
			}
			try {
				bfw.append(tipoDePregunta.equals(
						"1") ? String.format("INSERT INTO preguntas (tipo, enunciado, respuesta_correcta) VALUES ('vf', '%s', '%s');%n", enunciado, respuestaCorrecta) : String.format("INSERT INTO preguntas (tipo, enunciado, respuesta_correcta, respuesta_1, respuesta_2, respuesta_3, respuesta_4) VALUES ('sc', '%s', '%s', '%s', '%s', '%s' , '%s');%n", enunciado, respuestaCorrecta, respuesta1, respuesta2, respuesta3, respuesta4));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}
}
