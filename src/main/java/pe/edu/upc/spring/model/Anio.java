package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Anio")
public class Anio implements Serializable{

	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnio;
	
	@Column(name="Anio", nullable = false)
	private int anio;

	public Anio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Anio(int idAnio, int anio) {
		super();
		this.idAnio = idAnio;
		this.anio = anio;
	}

	public int getIdAnio() {
		return idAnio;
	}

	public void setIdAnio(int idAnio) {
		this.idAnio = idAnio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anio;
		result = prime * result + idAnio;
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
		Anio other = (Anio) obj;
		if (anio != other.anio)
			return false;
		if (idAnio != other.idAnio)
			return false;
		return true;
	}

}
