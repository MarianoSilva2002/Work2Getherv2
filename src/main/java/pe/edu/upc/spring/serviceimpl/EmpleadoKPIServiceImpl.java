package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Empleado_KPI;
import pe.edu.upc.spring.repository.IEmpleadoKPIRepository;
import pe.edu.upc.spring.service.IEmpleadoKPIService;

@Service
public class EmpleadoKPIServiceImpl implements IEmpleadoKPIService{

	@Autowired
	private IEmpleadoKPIRepository dEmpleado_KPI;
	
	@Override
	@Transactional
	public boolean grabar(Empleado_KPI empleado_KPI) {
		Empleado_KPI objEmpleado_KPI = dEmpleado_KPI.save(empleado_KPI);
		if(objEmpleado_KPI == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idEmpleado_KPI) {
		dEmpleado_KPI.deleteById(idEmpleado_KPI);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado_KPI> listarId(int idEmpleado_KPI) {
		return dEmpleado_KPI.findById(idEmpleado_KPI);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado_KPI> listar() {
		return dEmpleado_KPI.findAll();
	}

	
}

