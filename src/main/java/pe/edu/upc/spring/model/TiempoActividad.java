package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TiempoActividad")
public class TiempoActividad implements Serializable{
private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTiempoActividad;
	
	@Column(name="HoraInicio", nullable = true)
	@Temporal(TemporalType.TIME)
	private Date HoraInicio;
	
	@Column(name="HoraFin", nullable = true)
	@Temporal(TemporalType.TIME)
	private Date HoraFin;
	
	@Column(name="DiaInicio", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date DiaInicio;
	
	@Column(name="DiaFinal", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date DiaFinal;
	
	@Column(name="TiempoInvertido", nullable = true)
	private Date TiempoInvertido;

	public TiempoActividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TiempoActividad(int idTiempoActividad, Date horaInicio, Date horaFin, Date diaInicio, Date diaFinal,
			Date tiempoInvertido) {
		super();
		this.idTiempoActividad = idTiempoActividad;
		HoraInicio = horaInicio;
		HoraFin = horaFin;
		DiaInicio = diaInicio;
		DiaFinal = diaFinal;
		TiempoInvertido = tiempoInvertido;
	}

	public int getIdTiempoActividad() {
		return idTiempoActividad;
	}

	public void setIdTiempoActividad(int idTiempoActividad) {
		this.idTiempoActividad = idTiempoActividad;
	}

	public Date getHoraInicio() {
		return HoraInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		HoraInicio = horaInicio;
	}

	public Date getHoraFin() {
		return HoraFin;
	}

	public void setHoraFin(Date horaFin) {
		HoraFin = horaFin;
	}

	public Date getDiaInicio() {
		return DiaInicio;
	}

	public void setDiaInicio(Date diaInicio) {
		DiaInicio = diaInicio;
	}

	public Date getDiaFinal() {
		return DiaFinal;
	}

	public void setDiaFinal(Date diaFinal) {
		DiaFinal = diaFinal;
	}

	public Date getTiempoInvertido() {
		return TiempoInvertido;
	}

	public void setTiempoInvertido(Date tiempoInvertido) {
		TiempoInvertido = tiempoInvertido;
	}

}
