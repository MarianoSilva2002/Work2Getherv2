package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.Empleado_KPI;

public interface IEmpleadoKPIRepository {

	@Query("from Empleado_KPI where p.Empleado_KPI like %:Empleado_KPI%")
	List<Empleado_KPI> buscarEmpleado_KPI(@Param("Empleado_KPI") String Empleado_KPI);

}
