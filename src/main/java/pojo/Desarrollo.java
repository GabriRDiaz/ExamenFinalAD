package pojo;
import java.util.List;

import javax.persistence.*;

@Entity
public class Desarrollo {
	@Id
	private int id;
	@Column
	private String nombre;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="idDes", foreignKey = @ForeignKey(name="fk_desarrollador"))
	private List<Videojuego> videojuegos;
	public Desarrollo(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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
	
	public List<Videojuego> getVideojuegos(){
		return videojuegos;
	}
}
