package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Anio;

public interface IAnioService {
	
	public boolean grabar(Anio anio);
	public void eliminar(int idAnio);
	public Optional<Anio> listarId(int idAnio);
	public List<Anio> listar();
	public List<Anio> buscarNombre(int nombre);
}
