package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.KPI;

@Repository
public interface IKPIRepository extends JpaRepository<KPI, Integer>{

	@Query("from KPI k where k.Nombre like %:nombre%")
	List<KPI> buscarKPI(@Param("nombre") String nombre);	

}
