package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Actividad;
import pe.edu.upc.spring.model.TiempoActividad;
import pe.edu.upc.spring.repository.IActividadRepository;
import pe.edu.upc.spring.service.IActividadService;
import pe.edu.upc.spring.service.ITiempoActividadService;

@Service
public class ActividadServiceImpl implements IActividadService{

	@Autowired
	private IActividadRepository dActividad;
	
	@Autowired
	private ITiempoActividadService taService;
	
	@Override
	@Transactional
	public boolean grabar(Actividad Actividad) {
		int ExisteActividad = dActividad.existeActividad(Actividad.getIdActividad());
		if(ExisteActividad>0)
		{
			Actividad objActividad = dActividad.save(Actividad);
			if(objActividad == null)
				return false;
			else
				return true;
		}
		else
		{
			TiempoActividad ta = new TiempoActividad();
			ta.setNroPausas(0);
			taService.grabar(ta);
			Actividad.setTiempo(taService.listar().get(taService.listar().size()-1));
			Actividad.setEstado("Pendiente");
			Actividad objActividad = dActividad.save(Actividad);
			if(objActividad == null)
				return false;
			else
				return true;
		}
	}
	

	@Override
	@Transactional
	public void eliminar(int idActividad) {
		dActividad.deleteById(idActividad);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Actividad> listarId(int idActividad) {
		return dActividad.findById(idActividad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Actividad> listar() {
		return dActividad.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> buscarNombre(String nombre){
		return dActividad.buscarNombre(nombre);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> buscarEstado(String estado){
		return dActividad.buscarEstado(estado);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Actividad> buscarPrioritario(String prioridad){
		return dActividad.buscarPrioritario(prioridad);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Actividad> filtro(String estado, String prioridad){
		return dActividad.filtro(estado, prioridad);
	}


	@Override	
	@Transactional(readOnly=true)
	public List<Actividad> actividadesRealizadas() {
		return dActividad.actividadesRealizadas();
	}


	@Override
	@Transactional(readOnly=true)
	public List<Actividad> actividadesRealizadasCreadasporJefe(int idJefe) {
		return dActividad.actividadesRealizadasCreadasporJefe(idJefe);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Actividad> actividadesCreadasporJefe(int idJefe) {
		return dActividad.actividadesCreadasporJefe(idJefe);
	}
	@Override
	 @Transactional(readOnly=true)
	 public List<Actividad> actividadesOrderByFechaLimite() {
	    return dActividad.actividadesOrderByFechaLimite();
	}

	@Override	 
	@Transactional(readOnly=true)
	public List<Actividad> filtroporJefe(String estado, String priodidad, int idJefe) {
		return dActividad.filtroporJefe(estado, priodidad, idJefe);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Actividad> actividadesOrderByFechaLimiteporJefe(int idJefe) {
		return dActividad.actividadesOrderByFechaLimiteporJefe(idJefe);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Actividad> actividadesOrderByFechaLimiteporEmpleado(int idEmpleado) {
		return dActividad.actividadesOrderByFechaLimiteporEmpleado(idEmpleado);
	}


	@Override
	@Transactional(readOnly=true)
	public int existeActividad(int idActividad) {
		return dActividad.existeActividad(idActividad);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Actividad> actividadesRealizadasporEmpleado(int idEmpleado) {
		return dActividad.actividadesRealizadasporEmpleado(idEmpleado);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Actividad> actividadesCreadasporEmpleado(int idEmpleado) {
		return dActividad.actividadesCreadasporEmpleado(idEmpleado);
	}
}
