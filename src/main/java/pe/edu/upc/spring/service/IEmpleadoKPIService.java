package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Empleado_KPI;

public interface IEmpleadoKPIService {
	
	public boolean grabar(Empleado_KPI empleado_KPI);
	public void eliminar(int idEmpleado_KPI);
	public Optional<Empleado_KPI> listarId(int idEmpleado_KPI);
	public List<Empleado_KPI> listar();
	public List<Empleado_KPI> buscarEmpleado_KPI(String Empleado_KPI);
}
