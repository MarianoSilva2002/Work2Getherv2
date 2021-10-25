package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.TiempoActividad;

public interface ITiempoActividadService {

	public boolean grabar(TiempoActividad tiempoactividad);
	public void eliminar(int idTiempoActividad);
	public Optional<TiempoActividad> listarId(int idTiempoActividad);
	public List<TiempoActividad> listar();
	}
