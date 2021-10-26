package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Mensajes;

public interface IMensajeService {

	public boolean grabar(Mensajes mensajes);
	public void eliminar(int idMensajes);
	public Optional<Mensajes> listarId(int idMensajes);
	public List<Mensajes> listar();
	public List<Mensajes> buscarMensaje(String mensaje);
	}
