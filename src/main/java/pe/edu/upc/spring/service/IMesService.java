package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Mes;

public interface IMesService {
	
	public boolean grabar(Mes mes);
	public void eliminar(int idMes);
	public Optional<Mes> listarId(int idMes);
	public List<Mes> listar();
	public List<Mes> buscarMes(String mes);
}
