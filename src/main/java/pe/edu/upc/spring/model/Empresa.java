package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Empresa")
public class Empresa implements Serializable{
private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpresa;
	
	@Column(name="Nombre", nullable = false, length = 60)
	private String Nombre;
	
	@Column(name="RUC", nullable = false)
	private long RUC;
	
	@Column(name="Razon_Social", nullable = false, length = 60)
	private String RazonSocial;
	
	@Column(name="Direccion", nullable = false, length = 60)
	private String Direccion;
	
	@Column(name="Distrito", nullable = false, length = 60)
	private String Distrito;

	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empresa(int idEmpresa, String nombre, long rUC, String razonSocial, String direccion, String distrito) {
		super();
		this.idEmpresa = idEmpresa;
		Nombre = nombre;
		RUC = rUC;
		RazonSocial = razonSocial;
		Direccion = direccion;
		Distrito = distrito;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public long getRUC() {
		return RUC;
	}

	public void setRUC(long rUC) {
		RUC = rUC;
	}

	public String getRazonSocial() {
		return RazonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getDistrito() {
		return Distrito;
	}

	public void setDistrito(String distrito) {
		Distrito = distrito;
	}
}
