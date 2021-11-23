package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.Empleado_KPI;

public interface IEmpleadoKPIRepository extends JpaRepository<Empleado_KPI, Integer>{
	
	@Query("from Empleado_KPI k where k.kpi.Nombre like %:kPI%")
	List<Empleado_KPI> buscarKPI(@Param("kPI") String kPI);
	
	@Query("from Empleado_KPI a where a.anio.anio like %:anio%")
	List<Empleado_KPI> buscarAnio(@Param("anio") int anio);
	
	@Query("from Empleado_KPI j where j.empleado.nombre like %:empleado%")
	List<Empleado_KPI> buscarEmpleado(@Param("empleado") String empleado);	
	
	@Query("from Empleado_KPI m where m.mes.mes like %:mes%")
	List<Empleado_KPI> buscarMes(@Param("mes") String mes);	
	
	@Query("from Empleado_KPI m where m.mes.mes like %:mes% and m.anio.anio = :anio and m.empleado.idEmpleado =:empleado")
	List<Empleado_KPI> filtroKPIs(@Param("mes") String mes, @Param("anio") int anio, @Param("empleado") int empleado);
	
}
