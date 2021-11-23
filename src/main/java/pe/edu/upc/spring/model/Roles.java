package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Roles")
public class Roles implements Serializable{
	
	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRol;
	
	@NotEmpty(message="El nombre del rol es necesario")
	@Column(name="Nombre", nullable = false, length = 60)
	private String Nombre;
	
	@NotEmpty(message="La descripcion del rol es necesaria")
	@Column(name="Descripcion", nullable = false, length = 200)
	private String Descripcion;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int idRol, String nombre, Jefe jefe) {
		super();
		this.idRol = idRol;
		Nombre = nombre;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	
}
