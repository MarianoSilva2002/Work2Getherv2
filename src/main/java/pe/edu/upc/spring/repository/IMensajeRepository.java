package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Mensajes;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensajes, Integer>{
	
	@Query("from Mensajes e where e.Mensaje like %:mensaje%")
	List<Mensajes> buscarMensaje(@Param("mensaje") String mensaje);
	
	@Query("from Mensajes e where e.Emisor_correo like %:Emisor_correo%")
	List<Mensajes> emisorCorreo(@Param("Emisor_correo") String Emisor_correo);
	
	@Query("from Mensajes e where e.Receptor_correo like %:Receptor_correo%")
	List<Mensajes> receptorCorreo(@Param("Receptor_correo") String Receptor_correo);

}
