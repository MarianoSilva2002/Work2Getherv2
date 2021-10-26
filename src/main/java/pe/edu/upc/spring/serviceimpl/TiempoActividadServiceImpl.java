package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.TiempoActividad;
import pe.edu.upc.spring.repository.ITiempoActividadRepository;
import pe.edu.upc.spring.service.ITiempoActividadService;

@Service
public class TiempoActividadServiceImpl implements ITiempoActividadService{

	@Autowired
	private ITiempoActividadRepository dTiempoActividad;
	
	@Override
	@Transactional
	public boolean grabar(TiempoActividad tiempoActividad) {
		TiempoActividad objTiempoActividad = dTiempoActividad.save(tiempoActividad);
		if(objTiempoActividad == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idTiempoActividad) {
		dTiempoActividad.deleteById(idTiempoActividad);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TiempoActividad> listarId(int idTiempoActividad) {
		return dTiempoActividad.findById(idTiempoActividad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TiempoActividad> listar() {
		return dTiempoActividad.findAll();
	}
	
}
