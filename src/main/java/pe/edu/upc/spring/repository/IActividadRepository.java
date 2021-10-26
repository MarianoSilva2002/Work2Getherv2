package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Actividad;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Integer>{
	
	@Query("from Actividad a where a.nombre like %:nombre%")
	List<Actividad> buscarNombre(@Param("nombre") String nombre);
	
	@Query("from Actividad a where a.estado like %:estado%")
	List<Actividad> buscarEstado(@Param("estado") String estado);
	
	@Query("from Actividad a where a.prioridad = 1")
	List<Actividad> buscarPrioritario();
}
