package com.example.aplicacion.service;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import com.example.aplicacion.model.Pregunta;
import com.example.aplicacion.model.PreguntaSC;
import com.example.aplicacion.model.PreguntaVF;


@Service
public class PreguntaService {
	
	public static List<String[]> leeTXT() {
		File f = new File("C:\\Users\\Migue\\Desktop\\pcp.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		List <String[]> lineas = new ArrayList<>();
		br.lines().forEach(s-> lineas.add(s.split("\\|")));
		return lineas;
	}
	
	public static List<Pregunta> listaDePreguntas() {
		List <String[]> lineas = leeTXT();
		List<Pregunta> listaDePreguntas = new ArrayList<>();
		for (String[] linea : lineas) {
			if (linea[0].equals("1")) {
				listaDePreguntas.add(new PreguntaVF(linea[1],linea[2]));
				System.out.println(linea[1]);
				}
			else if (linea[0].equals("2")) {
				listaDePreguntas.add(new PreguntaSC(linea[1],linea[2],linea[3],linea[4],linea[5]));
				System.out.println(linea[1]);
			}
		}
		return listaDePreguntas;
	}
	
	public Pregunta preguntaAleatoria() {
		int tamanioListaPreguntas = listaDePreguntas().size();
		return listaDePreguntas().get(new Random().nextInt(0,tamanioListaPreguntas-1));
	}
	
	public Pregunta preguntaQueSeEnvio (String enunciadoPreguntaEnviada) {
		Pregunta p = null;
		for (Pregunta preguntaEnLista : listaDePreguntas())
			if(preguntaEnLista.getEnunciado().equals(enunciadoPreguntaEnviada)) p = preguntaEnLista;
		return p;
	}

}
