package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Roles;
import pe.edu.upc.spring.repository.IRolesRepository;
import pe.edu.upc.spring.service.IRolesService;

@Service
public class RolesServiceImpl implements IRolesService{

	@Autowired
	private IRolesRepository dRoles;
	
	@Override
	@Transactional
	public boolean grabar(Roles rol) {
		Roles objRol = dRoles.save(rol);
		if(objRol == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idRol) {
		dRoles.deleteById(idRol);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Roles> listarId(int idRol) {
		return dRoles.findById(idRol);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Roles> listar() {
		return dRoles.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Roles> buscarNombre(String nombre) {
		return dRoles.buscarNombre(nombre);
	}
	
}
