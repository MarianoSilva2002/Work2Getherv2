package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Actividad;

public interface IActividadService {

	public boolean grabar(Actividad actividad);
	public void eliminar(int idActividad);
	public Actividad listarId(int idActividad);
	public List<Actividad> listar();
	public List<Actividad> buscarNombre(String nombre);
	public List<Actividad> buscarEstado(String estado);
	public List<Actividad> buscarPrioritario(String prioridad);
	public List<Actividad> filtro(String estado, String prioridad);
	public List<Actividad> filtroporJefe(String estado, String priodidad,int idJefe);
	public List<Actividad> actividadesRealizadas();
	public List<Actividad> actividadesRealizadasCreadasporJefe(int idJefe);
	public List<Actividad> actividadesCreadasporJefe(int idJefe);
	public List<Actividad> actividadesOrderByFechaLimite();
	public List<Actividad> actividadesOrderByFechaLimiteporJefe(int idJefe);
	public List<Actividad> actividadesOrderByFechaLimiteporEmpleado(int idEmpleado);
	public int existeActividad(int idActividad);
	public List<Actividad> actividadesRealizadasporEmpleado(int idEmpleado);
	public List<Actividad> actividadesCreadasporEmpleado(int idEmpleado);

	}
