package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Empresa;

public interface IEmpresaService {

	public boolean grabar(Empresa empresa);
	public void eliminar(int idEmpresa);
	public Optional<Empresa> listarId(int idEmpresa);
	public List<Empresa> listar();
	public List<Empresa> buscarNombre(String nombre);
	public List<Empresa> buscarDistrito(String distrito);
	}
