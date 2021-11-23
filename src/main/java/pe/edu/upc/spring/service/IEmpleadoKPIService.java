package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.Empleado_KPI;

public interface IEmpleadoKPIService {
	
	public boolean grabar(Empleado_KPI empleado_KPI);
	public void eliminar(int idEmpleado_KPI);
	public Optional<Empleado_KPI> listarId(int idEmpleado_KPI);
	public List<Empleado_KPI> listar();
	public List<Empleado_KPI> buscarAnio(int anio);
	public List<Empleado_KPI> buscarMes(String mes);
	public List<Empleado_KPI> buscarKPI(String kPI);
	public List<Empleado_KPI> buscarEmpleado(String empleado);
	public List<Empleado_KPI> filtroKPIs(String mes, int anio, int empleado);

}
