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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Actividad")
public class Actividad implements Serializable{
	
	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idActividad;
	
	@Column(name="Nombre", nullable = false, length = 60)
	private String Nombre;
	
	@Column(name="Descripcion", nullable = false, length = 1000)
	private String Descripcion;
	
	@Column(name="HorasEstimadas", nullable = false)
	private int HorasEstimadas;
	
	@Column(name="HorasInvertidas", nullable = true)
	private Date HorasInvertidas;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FechaLimite", nullable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date FechaLimite;
	
	@Column(name="Prioridad", nullable = false)
	private Boolean Prioridad;
	
	@Column(name="Estado", nullable = false, length = 50)
	private String Estado;

	@ManyToOne
	@JoinColumn(name="idEmpleado", nullable = false)
	private Empleado empleado;
	
	@OneToOne
	@JoinColumn(name="idTiempoActividad", nullable = false)
	private TiempoActividad tiempo;
	
	public Actividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actividad(int idActividad, String nombre, String descripcion, int horasEstimadas, Date horasInvertidas,
			Date fechaLimite, Boolean prioridad, String estado, Jefe jefe, Empleado empleado, TiempoActividad tiempo) {
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

	public Date getHorasInvertidas() {
		return HorasInvertidas;
	}

	public void setHorasInvertidas(Date horasInvertidas) {
		HorasInvertidas = horasInvertidas;
	}

	public Date getFechaLimite() {
		return FechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		FechaLimite = fechaLimite;
	}

	public Boolean getPrioridad() {
		return Prioridad;
	}

	public void setPrioridad(Boolean prioridad) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Descripcion == null) ? 0 : Descripcion.hashCode());
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + ((FechaLimite == null) ? 0 : FechaLimite.hashCode());
		result = prime * result + HorasEstimadas;
		result = prime * result + ((HorasInvertidas == null) ? 0 : HorasInvertidas.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Prioridad == null) ? 0 : Prioridad.hashCode());
		result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
		result = prime * result + idActividad;
		result = prime * result + ((tiempo == null) ? 0 : tiempo.hashCode());
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
		Actividad other = (Actividad) obj;
		if (Descripcion == null) {
			if (other.Descripcion != null)
				return false;
		} else if (!Descripcion.equals(other.Descripcion))
			return false;
		if (Estado == null) {
			if (other.Estado != null)
				return false;
		} else if (!Estado.equals(other.Estado))
			return false;
		if (FechaLimite == null) {
			if (other.FechaLimite != null)
				return false;
		} else if (!FechaLimite.equals(other.FechaLimite))
			return false;
		if (HorasEstimadas != other.HorasEstimadas)
			return false;
		if (HorasInvertidas == null) {
			if (other.HorasInvertidas != null)
				return false;
		} else if (!HorasInvertidas.equals(other.HorasInvertidas))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Prioridad == null) {
			if (other.Prioridad != null)
				return false;
		} else if (!Prioridad.equals(other.Prioridad))
			return false;
		if (empleado == null) {
			if (other.empleado != null)
				return false;
		} else if (!empleado.equals(other.empleado))
			return false;
		if (idActividad != other.idActividad)
			return false;
		if (tiempo == null) {
			if (other.tiempo != null)
				return false;
		} else if (!tiempo.equals(other.tiempo))
			return false;
		return true;
	}
	
}
