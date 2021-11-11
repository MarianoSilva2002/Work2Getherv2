package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Jefe;

@Repository
public interface IJefeRepository extends JpaRepository<Jefe, Integer>{

	@Query("from Jefe j where j.nombre like %:nombre%")
	List<Jefe> buscarNombre(@Param("nombre") String nombre);	
	
	@Query("from Jefe c where c.correo = :correo and c.contrasena = :contrasena")
	List<Jefe> buscarContrasena(@Param("correo") String correo, @Param("contrasena") String contrasena);

}
