package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Anio;

@Repository
public interface IAnioRepository extends JpaRepository<Anio, Integer>{

	@Query("from Anio a where a.anio like %:anio%")
	List<Anio> buscarAnio(@Param("anio") int anio);
}
