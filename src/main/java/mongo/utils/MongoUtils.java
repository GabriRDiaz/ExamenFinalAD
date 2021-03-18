package mongo.utils;

import static com.mongodb.client.model.Projections.include;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import pojo.Desarrollo;
import pojo.Videojuego;

public class MongoUtils {
	public static void insertarInfo(ArrayList<Videojuego> videojuegos, ArrayList<Desarrollo> desarrolladores) {
		MongoClient cliente = new MongoClient("localhost",27017);
		MongoDatabase db = cliente.getDatabase("videojuegosmongo");
		MongoCollection<Document> mongoVideojuegos = db.getCollection("videojuegos");
		MongoCollection<Document> mongoDesarrolladores = db.getCollection("desarrolladores");
		ArrayList<Document> docVideojuegos = new ArrayList<Document>();
		videojuegos.forEach(v->{
			Document mongoVideojuego = new Document();
			mongoVideojuego.put("id", v.getId());
			mongoVideojuego.put("nombre", v.getNombre());
			mongoVideojuego.put("salida", v.getSalida());
			mongoVideojuego.put("idDes", v.getIdDes());
			docVideojuegos.add(mongoVideojuego);
		});
		
		mongoVideojuegos.insertMany(docVideojuegos);
		System.out.println("Videojuegos insertados");
		
		ArrayList<Document> docDesarrolladores = new ArrayList<Document>();
		desarrolladores.forEach(d->{
			Document mongoDesarrollador = new Document();
			mongoDesarrollador.put("id", d.getId());
			mongoDesarrollador.put("nombre", d.getName());
			docDesarrolladores.add(mongoDesarrollador);
		});
		
		mongoDesarrolladores.insertMany(docDesarrolladores);
		System.out.println("Desarrolladores insertados");
	}
	public static void makeQuerySelect() {
		MongoClient cliente = new MongoClient("localhost",27017);
		MongoDatabase db = cliente.getDatabase("videojuegosmongo");
		MongoCollection<Document> mongoVideojuegos = db.getCollection("videojuegos");
		MongoCursor<Document> iterador = mongoVideojuegos.find(and(gte("salida",2010), lte("salida",2016))).iterator();
		while(iterador.hasNext()) {
			System.out.println(iterador.next());
		}
	}
	public static void makeQueryDelete() {
		MongoClient cliente = new MongoClient("localhost",27017);
		MongoDatabase db = cliente.getDatabase("videojuegosmongo");
		MongoCollection<Document> mongoVideojuegos = db.getCollection("videojuegos");
		FindIterable<Document> videojuegos = mongoVideojuegos.find();
		for(Document videojuego: videojuegos) {
			mongoVideojuegos.deleteMany(videojuego);
		}
	}
}
