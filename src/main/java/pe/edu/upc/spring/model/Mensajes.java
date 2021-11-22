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
	
	@Column(name="Emisor_correo", nullable = false, length = 60)
	private String Emisor_correo;
	
	@Column(name="Receptor_correo", nullable = false, length = 60)
	private String Receptor_correo;
	
	@ManyToOne
	@JoinColumn(name="idEmpleado", nullable = false)
	private Empleado empleado;

	public Mensajes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mensajes(int idMensaje, String mensaje, Date fechaMensaje, String emisor_correo, String receptor_correo, Empleado empleado,
			Jefe jefe) {
		super();
		this.idMensaje = idMensaje;
		Mensaje = mensaje;
		FechaMensaje = fechaMensaje;
		Emisor_correo = emisor_correo;
		Receptor_correo = receptor_correo;
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

	public String getEmisor_correo() {
		return Emisor_correo;
	}

	public void setEmisor_correo(String emisor_correo) {
		Emisor_correo = emisor_correo;
	}

	public String getReceptor_correo() {
		return Receptor_correo;
	}

	public void setReceptor_correo(String receptor_correo) {
		Receptor_correo = receptor_correo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}
