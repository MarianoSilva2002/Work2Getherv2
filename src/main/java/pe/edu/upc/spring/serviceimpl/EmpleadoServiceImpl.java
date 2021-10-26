package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Empleado;
import pe.edu.upc.spring.repository.IEmpleadoRepository;
import pe.edu.upc.spring.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoRepository dEmpleado;
	
	@Override
	@Transactional
	public boolean grabar(Empleado empleado) {
		Empleado objEmpleado = dEmpleado.save(empleado);
		if(objEmpleado == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idEmpleado) {
		dEmpleado.deleteById(idEmpleado);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado> listarId(int idEmpleado) {
		return dEmpleado.findById(idEmpleado);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> listar() {
		return dEmpleado.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> buscarNombre(String nombre) {
		return dEmpleado.buscarNombre(nombre);
	}
	
}
