package main;

import java.io.IOException;
import java.util.ArrayList;

import hibernate.utils.HibernateUtils;
import io.utils.CsvReader;
import mongo.utils.MongoUtils;
import pojo.Desarrollo;
import pojo.Videojuego;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Videojuego> videojuegos = CsvReader.leerVideojuegos();
		ArrayList<Desarrollo> desarrolladores = CsvReader.leerDesarrolladores();
//		debugCsv(videojuegos,desarrolladores);
//		HibernateUtils.hibernateQueries(videojuegos, desarrolladores);
//		MongoUtils.insertarInfo(videojuegos, desarrolladores);
		MongoUtils.makeQuerySelect();
		MongoUtils.makeQueryDelete();
	}

	private static void debugCsv(ArrayList<Videojuego> videojuegos, ArrayList<Desarrollo> desarrolladores) {
		videojuegos.forEach(v->{
			System.out.println(v.getId());
			System.out.println(v.getNombre());
			System.out.println(v.getSalida());
			System.out.println(v.getIdDes());
		});
		desarrolladores.forEach(d->{
			System.out.println(d.getId());
			System.out.println(d.getName());
		});
	}

}
