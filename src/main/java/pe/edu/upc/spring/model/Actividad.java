package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Actividad")
public class Actividad implements Serializable{
	
	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idActividad;
	
	@NotEmpty(message="El nombre de la activida es necesaria")
	@Size(min=4, max=20)
	@Column(name="Nombre")
	private String Nombre;
	
	@NotEmpty (message="La descripcion de la activida es necesaria")
	@Size(min=10, max=60)
	@Column(name="Descripcion")
	private String Descripcion;
	
	@Column(name="HorasEstimadas", nullable = false)
	private int HorasEstimadas;
	
	@Column(name="HorasInvertidas", nullable = true)
	private long HorasInvertidas;
	
	@NotNull(message = "La fecha de la actividad es obligatoria")
	@Future(message = "La fecha de la actividad debe de estar en el futuro")
	@Temporal(TemporalType.DATE)
	@Column(name="FechaLimite", nullable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date FechaLimite;
	
	@Column(name="Prioridad", nullable = false, length = 3)
	private String Prioridad;
	
	@Column(name="Estado", nullable = false, length = 50)
	private String Estado;

	@ManyToOne
	@JoinColumn(name="idEmpleado")
	private Empleado empleado;
	
	@OneToOne
	@JoinColumn(name="idTiempoActividad", nullable = false)
	private TiempoActividad tiempo;
	
	
	public Actividad() {
		super();
		// TODO Auto-generated constructor stub

	}

	public Actividad(int idActividad, String nombre, String descripcion, int horasEstimadas, long horasInvertidas,
			Date fechaLimite, String prioridad, String estado, Empleado empleado, TiempoActividad tiempo) {
		super();
		this.idActividad = idActividad;
		Nombre = nombre;
		Descripcion = descripcion;
		HorasEstimadas = horasEstimadas;
		HorasInvertidas = horasInvertidas;
		FechaLimite = fechaLimite;
		Prioridad = prioridad;
		Estado = estado;
		this.empleado = empleado;
		this.tiempo = tiempo;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
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

	public int getHorasEstimadas() {
		return HorasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		HorasEstimadas = horasEstimadas;
	}

	public long getHorasInvertidas() {
		return HorasInvertidas;
	}

	public void setHorasInvertidas(long horasInvertidas) {
		HorasInvertidas = horasInvertidas;
	}

	public Date getFechaLimite() {
		return FechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		FechaLimite = fechaLimite;
	}

	public String getPrioridad() {
		return Prioridad;
	}

	public void setPrioridad(String prioridad) {
		Prioridad = prioridad;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TiempoActividad getTiempo() {
		return tiempo;
	}

	public void setTiempo(TiempoActividad tiempo) {
		this.tiempo = tiempo;
	}
	
	
	
}
