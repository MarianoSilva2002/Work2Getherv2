package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Mes")
public class Mes implements Serializable{
	
	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMes;
	
	@Column(name="Mes", nullable = false, length = 15)
	private String mes;

	public Mes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mes(int idMes, String mes) {
		super();
		this.idMes = idMes;
		this.mes = mes;
	}

	public int getIdMes() {
		return idMes;
	}

	public void setIdMes(int idMes) {
		this.idMes = idMes;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	
}
