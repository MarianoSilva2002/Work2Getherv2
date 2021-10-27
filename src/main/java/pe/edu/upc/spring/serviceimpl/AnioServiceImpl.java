package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Anio;
import pe.edu.upc.spring.repository.IAnioRepository;
import pe.edu.upc.spring.service.IAnioService;

@Service
public class AnioServiceImpl implements IAnioService{

	@Autowired
	private IAnioRepository dAnio;
	
	@Override
	@Transactional
	public boolean grabar(Anio anio) {
		Anio objAnio = dAnio.save(anio);
		if(objAnio == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idAnio) {
		dAnio.deleteById(idAnio);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Anio> listarId(int idAnio) {
		return dAnio.findById(idAnio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Anio> listar() {
		return dAnio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Anio> buscarAnio(int anio) {
		return dAnio.buscarAnio(anio);
	}
	
}
