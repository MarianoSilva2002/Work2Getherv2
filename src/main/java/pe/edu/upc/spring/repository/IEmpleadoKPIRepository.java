package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.Anio;
import pe.edu.upc.spring.model.Empleado;
import pe.edu.upc.spring.model.Empleado_KPI;
import pe.edu.upc.spring.model.KPI;
import pe.edu.upc.spring.model.Mes;

public interface IEmpleadoKPIRepository extends JpaRepository<Empleado_KPI, Integer>{
	@Query("from Empleado_KPI v where v.empleado_KPI like %:empleado_KPI%")
	List<Empleado_KPI> buscarEmpleado_KPI(@Param("empleado_KPI") String empleado_KPI);
	
	@Query("from KPI k where k.KPI like %:kPI%")
	List<Empleado_KPI> buscarKPI(@Param("kPI") String kPI);
	
	@Query("from Anio a where a.anio like %:anio%")
	List<Empleado_KPI> buscarAnio(@Param("anio") int anio);
	
	@Query("from Empleado j where j.empleado like %:empleado%")
	List<Empleado_KPI> buscarEmpleado(@Param("empleado") String empleado);	
	
	@Query("from Mes m where m.mes like %:mes%")
	List<Empleado_KPI> buscarMes(@Param("mes") String mes);	
}
