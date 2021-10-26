package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="KPI")
public class KPI implements Serializable{
	
	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKPI;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CantidadEstimada;
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + idKPI;
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
		KPI other = (KPI) obj;
		if (CantidadEstimada != other.CantidadEstimada)
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (idKPI != other.idKPI)
			return false;
		return true;
	}

}
