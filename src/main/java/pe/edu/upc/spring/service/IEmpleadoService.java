package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Empleado;


public interface IEmpleadoService {

	public boolean grabar(Empleado empleado);
	public void eliminar(int idEmpleado);
	public Optional<Empleado> listarId(int idEmpleado);
	public List<Empleado> listar();
	public List<Empleado> buscarEmpleado(String empleado);
	public List<Empleado> buscarContrasena(String correo, String contrasena);
	public List<Empleado> EmpleadosdelJefe(int idJefe);
	}
