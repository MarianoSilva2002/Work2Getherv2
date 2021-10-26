package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Mensajes;

@Repository
public interface IMensajeRepository extends JpaRepository<Mensajes, Integer>{

	@Query("from Mensajes e where e.mensaje like %:Mensaje%")
	List<Mensajes> buscarMensaje(@Param("mensaje") String mensaje);
	
	

}