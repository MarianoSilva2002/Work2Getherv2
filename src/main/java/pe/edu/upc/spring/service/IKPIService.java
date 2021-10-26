package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.KPI;

public interface IKPIService {

	public boolean grabar(KPI kp);
	public void eliminar(int idKPI);
	public Optional<KPI> listarId(int idPI);
	public List<KPI> listar();
	public List<KPI> buscarKPI(String nombre);
	}
