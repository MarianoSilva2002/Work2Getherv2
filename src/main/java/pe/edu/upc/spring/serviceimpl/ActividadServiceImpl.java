package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Actividad;
import pe.edu.upc.spring.repository.IActividadRepository;
import pe.edu.upc.spring.service.IActividadService;

@Service
public class ActividadServiceImpl implements IActividadService{

	@Autowired
	private IActividadRepository dActividad;
	
	@Override
	@Transactional
	public boolean grabar(Actividad Actividad) {
		Actividad objActividad = dActividad.save(Actividad);
		if(objActividad == null)
			return false;
		else
			return true;
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
	public List<Actividad> actividadesRealizadasporJefe(int idJefe) {
		return dActividad.actividadesRealizadasporJefe(idJefe);
	}
}
