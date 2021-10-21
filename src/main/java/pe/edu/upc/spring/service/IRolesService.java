package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Roles;

public interface IRolesService {

	public boolean grabar(Roles rol);
	public void eliminar(int idRol);
	public Optional<Roles> listarId(int idRol);
	public List<Roles> listar();
	public List<Roles> buscarNombre(String nombre);
	}
