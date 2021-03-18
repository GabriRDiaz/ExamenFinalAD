package pojo;
import javax.persistence.*;

@Entity
public class Videojuego {
	@Id
	private int id;
	@Column
	private String nombre;
	@Column
	private int salida;
	@Column
	private int idDes;
	public Videojuego(int id, String nombre, int salida, int idDes) {
		this.id = id;
		this.nombre = nombre;
		this.salida = salida;
		this.idDes = idDes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSalida() {
		return salida;
	}
	public void setSalida(int salida) {
		this.salida = salida;
	}
	public int getIdDes() {
		return idDes;
	}
	public void setIdDes(int idDes) {
		this.idDes = idDes;
	}
	
}
