package io.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import pojo.Desarrollo;
import pojo.Videojuego;


public class CsvReader {
	private static ArrayList<Videojuego> videojuegos = new ArrayList<Videojuego>();
	private static ArrayList<Desarrollo> desarrolladores = new ArrayList<Desarrollo>();
	
	public static ArrayList<Videojuego> leerVideojuegos() throws IOException{
		BufferedReader br = Files.newBufferedReader(Paths.get("D:\\Examen\\videojuegos.csv"));
		Stream<String> lines = br.lines();
		lines.forEach(v->{
			String[] field = v.split(",");
			videojuegos.add(new Videojuego(Integer.parseInt(field[0]), field[1],Integer.parseInt(field[2]),Integer.parseInt(field[3])));
		});
		return videojuegos;		
	}
	
	public static ArrayList<Desarrollo> leerDesarrolladores() throws IOException{
		BufferedReader br = Files.newBufferedReader(Paths.get("D:\\Examen\\desarrollo.csv"));
		Stream<String> lines = br.lines();
		lines.forEach(d->{
			String[] field = d.split(",");
			desarrolladores.add(new Desarrollo(Integer.parseInt(field[0]), field[1]));
		});
		return desarrolladores;		
	}
}
