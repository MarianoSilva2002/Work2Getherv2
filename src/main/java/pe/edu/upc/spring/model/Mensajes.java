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
import javax.persistence.Table;

@Entity
@Table(name="Mensaje")
public class Mensajes implements Serializable{
	
	private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMensaje;
	
	@Column(name="Mensaje", nullable = false, length = 1000)
	private String Mensaje;
	
	@Column(name="FechaMensaje", nullable = false)
	private Date FechaMensaje;
	
	@Column(name="Emisor_id", nullable = false)
	private int Emisor_id;
	
	@Column(name="Receptor_id", nullable = false)
	private int Receptor_id;
	
	@ManyToOne
	@JoinColumn(name="idEmpleado", nullable = false)
	private Empleado empleado;

	public Mensajes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mensajes(int idMensaje, String mensaje, Date fechaMensaje, int emisor_id, int receptor_id, Empleado empleado,
			Jefe jefe) {
		super();
		this.idMensaje = idMensaje;
		Mensaje = mensaje;
		FechaMensaje = fechaMensaje;
		Emisor_id = emisor_id;
		Receptor_id = receptor_id;
		this.empleado = empleado;
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	public Date getFechaMensaje() {
		return FechaMensaje;
	}

	public void setFechaMensaje(Date fechaMensaje) {
		FechaMensaje = fechaMensaje;
	}

	public int getEmisor_id() {
		return Emisor_id;
	}

	public void setEmisor_id(int emisor_id) {
		Emisor_id = emisor_id;
	}

	public int getReceptor_id() {
		return Receptor_id;
	}

	public void setReceptor_id(int receptor_id) {
		Receptor_id = receptor_id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Emisor_id;
		result = prime * result + ((FechaMensaje == null) ? 0 : FechaMensaje.hashCode());
		result = prime * result + ((Mensaje == null) ? 0 : Mensaje.hashCode());
		result = prime * result + Receptor_id;
		result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
		result = prime * result + idMensaje;
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
		Mensajes other = (Mensajes) obj;
		if (Emisor_id != other.Emisor_id)
			return false;
		if (FechaMensaje == null) {
			if (other.FechaMensaje != null)
				return false;
		} else if (!FechaMensaje.equals(other.FechaMensaje))
			return false;
		if (Mensaje == null) {
			if (other.Mensaje != null)
				return false;
		} else if (!Mensaje.equals(other.Mensaje))
			return false;
		if (Receptor_id != other.Receptor_id)
			return false;
		if (empleado == null) {
			if (other.empleado != null)
				return false;
		} else if (!empleado.equals(other.empleado))
			return false;
		if (idMensaje != other.idMensaje)
			return false;
		return true;
	}
	
}
