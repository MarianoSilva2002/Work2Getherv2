package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Jefe;
import pe.edu.upc.spring.repository.IJefeRepository;
import pe.edu.upc.spring.service.IJefeService;

@Service
public class JefeServiceImpl implements IJefeService{

	@Autowired
	private IJefeRepository dJefe;
	
	@Override
	@Transactional
	public boolean grabar(Jefe jefe) {
		Jefe objJefe = dJefe.save(jefe);
		if(objJefe == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idJefe) {
		dJefe.deleteById(idJefe);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Jefe> listarId(int idJefe) {
		return dJefe.findById(idJefe);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Jefe> listar() {
		return dJefe.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Jefe> buscarNombre(String nombre) {
		return dJefe.buscarNombre(nombre);
	}
	
}
