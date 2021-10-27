package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Mes;
import pe.edu.upc.spring.repository.IMesRepository;
import pe.edu.upc.spring.service.IMesService;

@Service
public class MesServiceImpl implements IMesService{

	@Autowired
	private IMesRepository dMes;
	
	@Override
	@Transactional
	public boolean grabar(Mes mes) {
		Mes objMes = dMes.save(mes);
		if(objMes == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idMes) {
		dMes.deleteById(idMes);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mes> listarId(int idMes) {
		return dMes.findById(idMes);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mes> listar() {
		return dMes.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mes> buscarMes(String mes) {
		return dMes.buscarMes(mes);
	}
	
}
