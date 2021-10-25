package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TiempoActividad")
public class TiempoActividad implements Serializable{
private static final long serialVersionUID = 11;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTiempoActividad;
	
	@Column(name="HoraInicio", nullable = true)
	private Date HoraInicio;
	
	@Column(name="HoraFin", nullable = true)
	private Date HoraFin;
	
	@Column(name="DiaInicio", nullable = true)
	private Date DiaInicio;
	
	@Column(name="DiaFinal", nullable = true)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DiaFinal == null) ? 0 : DiaFinal.hashCode());
		result = prime * result + ((DiaInicio == null) ? 0 : DiaInicio.hashCode());
		result = prime * result + ((HoraFin == null) ? 0 : HoraFin.hashCode());
		result = prime * result + ((HoraInicio == null) ? 0 : HoraInicio.hashCode());
		result = prime * result + ((TiempoInvertido == null) ? 0 : TiempoInvertido.hashCode());
		result = prime * result + idTiempoActividad;
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
		TiempoActividad other = (TiempoActividad) obj;
		if (DiaFinal == null) {
			if (other.DiaFinal != null)
				return false;
		} else if (!DiaFinal.equals(other.DiaFinal))
			return false;
		if (DiaInicio == null) {
			if (other.DiaInicio != null)
				return false;
		} else if (!DiaInicio.equals(other.DiaInicio))
			return false;
		if (HoraFin == null) {
			if (other.HoraFin != null)
				return false;
		} else if (!HoraFin.equals(other.HoraFin))
			return false;
		if (HoraInicio == null) {
			if (other.HoraInicio != null)
				return false;
		} else if (!HoraInicio.equals(other.HoraInicio))
			return false;
		if (TiempoInvertido == null) {
			if (other.TiempoInvertido != null)
				return false;
		} else if (!TiempoInvertido.equals(other.TiempoInvertido))
			return false;
		if (idTiempoActividad != other.idTiempoActividad)
			return false;
		return true;
	}

}
