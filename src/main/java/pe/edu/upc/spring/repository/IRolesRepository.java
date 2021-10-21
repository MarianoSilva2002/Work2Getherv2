package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Roles;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Integer>{

	@Query("from Roles r where r.nombre like %:nombre%")
	List<Roles> buscarNombre(@Param("nombre") String nombre);	

}
