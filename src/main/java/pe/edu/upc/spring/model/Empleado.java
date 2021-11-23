package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Empleado")
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpleado;
	
	@NotEmpty
	@Column(name="nombre", nullable = false, length = 60)
	private String nombre;
	
	@NotEmpty
	@Column(name="apellidoPaterno", nullable = false, length = 60)
	private String aPaterno;
	
	@NotEmpty
	@Column(name="apellidoMaterno", nullable = false, length = 60)
	private String aMaterno;
	
	@NotEmpty
	@Column(name="genero", nullable = false, length = 50)
	private String genero;
	
	@NotEmpty
	@Email
	@Column(name="correo", nullable = false, length = 60)
	private String correo;
	
	@NotEmpty
	@Column(name="contrasena", nullable = false, length = 60)
	private String contrasena;
	
	@ManyToOne
	@JoinColumn(name="idJefe", nullable = false)
	private Jefe jefe;
	
	@ManyToOne
	@JoinColumn(name="idRol", nullable = false)
	private Roles rol;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(int idEmpleado, String nombre, String aPaterno, String aMaterno, String genero, String correo,
			String contrasena, Jefe jefe, Roles rol) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
		this.genero = genero;
		this.correo = correo;
		this.contrasena = contrasena;
		this.jefe = jefe;
		this.rol = rol;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getaPaterno() {
		return aPaterno;
	}

	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	public String getaMaterno() {
		return aMaterno;
	}

	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Jefe getJefe() {
		return jefe;
	}

	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}
	
	
}
