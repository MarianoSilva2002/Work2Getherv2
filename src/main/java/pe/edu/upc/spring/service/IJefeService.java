package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Jefe;

public interface IJefeService {

	public boolean grabar(Jefe jefe);
	public void eliminar(int idJefe);
	public Optional<Jefe> listarId(int idJefe);
	public List<Jefe> listar();
	public List<Jefe> buscarNombre(String nombre);
	}
