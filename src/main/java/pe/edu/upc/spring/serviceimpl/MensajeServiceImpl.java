package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Mensajes;
import pe.edu.upc.spring.repository.IMensajeRepository;
import pe.edu.upc.spring.service.IMensajeService;

@Service
public class MensajeServiceImpl implements IMensajeService{

	@Autowired
	private IMensajeRepository dMensaje;
	
	@Override
	@Transactional
	public boolean grabar(Mensajes mensaje) {
		Mensajes objMensaje = dMensaje.save(mensaje);
		if(objMensaje == null)
			return false;
		else
			return true;
	}
	

	@Override
	@Transactional
	public void eliminar(int idMensaje) {
		dMensaje.deleteById(idMensaje);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mensajes> listarId(int idMensaje) {
		return dMensaje.findById(idMensaje);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mensajes> listar() {
		return dMensaje.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Mensajes> buscarMensaje(String mensaje) {
		return dMensaje.buscarMensaje(mensaje);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Mensajes> emisorCorreo(String Emisor_correo) {
		return dMensaje.emisorCorreo(Emisor_correo);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Mensajes> receptorCorreo(String Receptor_correo) {
		return dMensaje.receptorCorreo(Receptor_correo);
	}


	@Override
	public List<Mensajes> mensajesEmpleadoyJefe(int idEmpleado) {
		return dMensaje.mensajesEmpleadoyJefe(idEmpleado);
	}
	
	
}
