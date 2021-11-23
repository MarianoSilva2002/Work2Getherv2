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
@Table(name="KPI")
public class KPI implements Serializable{
	
	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKPI;
	
	@NotEmpty
	@Column(name="Nombre", nullable = false, length = 60)
	private String Nombre;
	
	@Column(name="CantidadEstimada", nullable = false)
	private int CantidadEstimada;

	public KPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KPI(int idKPI, String nombre, int cantidadEstimada, Jefe jefe) {
		super();
		this.idKPI = idKPI;
		Nombre = nombre;
		CantidadEstimada = cantidadEstimada;
	}

	public int getIdKPI() {
		return idKPI;
	}

	public void setIdKPI(int idKPI) {
		this.idKPI = idKPI;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getCantidadEstimada() {
		return CantidadEstimada;
	}

	public void setCantidadEstimada(int cantidadEstimada) {
		CantidadEstimada = cantidadEstimada;
	}


}
