package hibernate.utils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import pojo.Desarrollo;
import pojo.Videojuego;

public class HibernateUtils {
	public static void hibernateQueries(ArrayList<Videojuego> videojuegos, ArrayList<Desarrollo> desarrolladores) {
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		desarrolladores.forEach(d->{
			ss.save(d);
		});
		videojuegos.forEach(v->{
			ss.save(v);
		});
		makeQuery(ss);
		ss.getTransaction().commit();
		ss.close();
		sf.close();
		sr.close();
	}

	private static void makeQuery(Session ss) {
		Query query = ss.createQuery("SELECT v.id,v.nombre FROM Videojuego v");
		List<Object[]> lista = (List<Object[]>) query.getResultList();
		lista.forEach(l->{
			System.out.println("Código: "+l[0]+"\nNombre: "+l[1]+"\n------");
		});
	}
}
