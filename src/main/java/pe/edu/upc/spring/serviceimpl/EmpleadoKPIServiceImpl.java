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
	private IEmpleadoKPIRepository vEmpleado_KPI;
	
	@Override
	@Transactional
	public boolean grabar(Empleado_KPI empleado_KPI) {
		Empleado_KPI objEmpleado_KPI = vEmpleado_KPI.save(empleado_KPI);
		if(objEmpleado_KPI == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idEmpleado_KPI) {
		vEmpleado_KPI.deleteById(idEmpleado_KPI);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado_KPI> listarId(int idEmpleado_KPI) {
		return vEmpleado_KPI.findById(idEmpleado_KPI);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado_KPI> listar() {
		return vEmpleado_KPI.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado_KPI> buscarAnio(int anio) {
		return vEmpleado_KPI.buscarAnio(anio);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Empleado_KPI> buscarMes(String mes) {
		return vEmpleado_KPI.buscarMes(mes);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Empleado_KPI> buscarKPI(String kPI) {
		return vEmpleado_KPI.buscarKPI(kPI);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Empleado_KPI> buscarEmpleado(String empleado) {
		return vEmpleado_KPI.buscarEmpleado(empleado);
	}
	
}

