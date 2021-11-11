package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer>{

	@Query("from Empleado j where j.nombre like %:empleado%")
	List<Empleado> buscarEmpleado(@Param("empleado") String empleado);
	
	@Query("from Empleado c where c.correo = :correo and c.contrasena = :contrasena")
	List<Empleado> buscarContrasena(@Param("correo") String correo, @Param("contrasena") String contrasena);
}
