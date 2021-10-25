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

@Entity
@Table(name="Empleado")
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpleado;
	
	@Column(name="nombre", nullable = false, length = 60)
	private String nombre;
	
	@Column(name="apellidoPaterno", nullable = false, length = 60)
	private String aPaterno;
	
	@Column(name="apellidoMaterno", nullable = false, length = 60)
	private String aMaterno;
	
	@Column(name="genero", nullable = false, length = 50)
	private String genero;
	
	@Column(name="correo", nullable = false, length = 60)
	private String correo;
	
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

	public void setIdJefe(int idEmpleado) {
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

	public void setEmpresa(Jefe jefe) {
		this.jefe = jefe;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aMaterno == null) ? 0 : aMaterno.hashCode());
		result = prime * result + ((aPaterno == null) ? 0 : aPaterno.hashCode());
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((jefe == null) ? 0 : jefe.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + idEmpleado;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (aMaterno == null) {
			if (other.aMaterno != null)
				return false;
		} else if (!aMaterno.equals(other.aMaterno))
			return false;
		if (aPaterno == null) {
			if (other.aPaterno != null)
				return false;
		} else if (!aPaterno.equals(other.aPaterno))
			return false;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (jefe == null) {
			if (other.jefe != null)
				return false;
		} else if (!jefe.equals(other.jefe))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (idEmpleado != other.idEmpleado)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}

	
	
}
