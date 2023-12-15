package com.example.demo.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class CargaDatos {

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
	
}
	

