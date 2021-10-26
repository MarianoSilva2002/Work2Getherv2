package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Mes;

@Repository
public interface IMesRepository extends JpaRepository<Mes, Integer>{

	@Query("from Mes m where m.nombre like %:nombre%")
	List<Mes> buscarNombre(@Param("nombre") String nombre);
}
