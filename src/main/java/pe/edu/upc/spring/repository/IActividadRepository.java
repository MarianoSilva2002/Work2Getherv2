package pe.edu.upc.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Actividad;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Integer>{
	
	@Query("from Actividad a where a.Nombre like %:nombre%")
	List<Actividad> buscarNombre(@Param("nombre") String nombre);
	
	@Query("from Actividad a where a.Estado like %:estado%")
	List<Actividad> buscarEstado(@Param("estado") String estado);
	
	@Query("from Actividad a where a.Prioridad like %:prioridad%")
	List<Actividad> buscarPrioritario(@Param("prioridad") String priodidad);
	
	@Query("from Actividad a where a.Estado like %:estado% and a.Prioridad like %:prioridad%")
	List<Actividad> filtro(@Param("estado") String estado, @Param("prioridad") String priodidad);
	
	@Query("from Actividad a where a.Estado = 'Realizado'")
	List<Actividad> actividadesRealizadas();
	
	@Query("from Actividad a where a.Estado = 'Realizado' and a.empleado.jefe.idJefe = :idJefe")
	List<Actividad> actividadesRealizadasCreadasporJefe(@Param("idJefe") int idJefe);
	
	@Query("from Actividad a where a.Estado != 'Realizado' and a.empleado.jefe.idJefe = :idJefe")
	List<Actividad> actividadesCreadasporJefe(@Param("idJefe") int idJefe);
	
	@Query("from Actividad a ORDER BY a.FechaLimite ASC")
	List<Actividad> actividadesOrderByFechaLimite();

	@Query("select count(a.idActividad) from Actividad a where a.idActividad =:idActividad")
	public int existeActividad(@Param("idActividad") int idActividad);
}
