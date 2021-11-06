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

}
