package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Actividad;

public interface IActividadService {

	public boolean grabar(Actividad actividad);
	public void eliminar(int idActividad);
	public Optional<Actividad> listarId(int idActividad);
	public List<Actividad> listar();
	public List<Actividad> buscarNombre(String nombre);
	public List<Actividad> buscarEstado(String estado);
	public List<Actividad> buscarPrioritario();
	}