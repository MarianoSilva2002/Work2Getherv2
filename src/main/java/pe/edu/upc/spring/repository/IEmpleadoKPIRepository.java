package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.Empleado_KPI;

public interface IEmpleadoKPIRepository {

	@Query("from Empleado_KPI  where e.nombre like %:nombre%")
	List<Empleado_KPI> buscarNombre(@Param("nombre") String nombre);
}
