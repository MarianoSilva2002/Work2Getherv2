package pe.edu.upc.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Empleado;
import pe.edu.upc.spring.model.Mes;
import pe.edu.upc.spring.model.Anio;
import pe.edu.upc.spring.model.KPI;
import pe.edu.upc.spring.model.Empleado_KPI;

import pe.edu.upc.spring.service.IEmpleadoService;
import pe.edu.upc.spring.service.IMesService;
import pe.edu.upc.spring.service.IAnioService;
import pe.edu.upc.spring.service.IKPIService;
import pe.edu.upc.spring.service.IEmpleadoKPIService;

@Controller
@RequestMapping("/empleado_KPI")
public class EmpleadoKPIController {

	@Autowired
	private IMesService mService;
	
	@Autowired
	private IAnioService aService;
	
	@Autowired
	private IKPIService kService;
	
	@Autowired
	private IEmpleadoService jService;
	
	@Autowired
	private IEmpleadoKPIService vService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; //"bienvenido" es una pagina del frontend
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEmpleado_KPI(Map<String, Object> model) {
		model.put("listaEmpleado_KPI", vService.listar());
		return "listEmpleados"; //"listEmpleados" es una pagina del frontend
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaEmpleados", jService.listar());
		model.addAttribute("listaMes", mService.listar());
		model.addAttribute("listaAnios", aService.listar());
		model.addAttribute("listaKPI", kService.listar());
		
		model.addAttribute("Empleados", new Empleado());
		model.addAttribute("Anios", new Anio());
		model.addAttribute("Mes", new Mes());
		model.addAttribute("KPI", new KPI());
		model.addAttribute("Empleado_KPI", new Empleado_KPI());
		return "empleado_KPI"; //"Empleado" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Empleado_KPI objEmpleado_KPI, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			model.addAttribute("listaEmpleados", jService.listar());
			model.addAttribute("listaMes", mService.listar());
			model.addAttribute("listaAnios", aService.listar());
			model.addAttribute("listaKPI", kService.listar());
			return "Empleado_KPI";
		}
		else {
			boolean flag = vService.grabar(objEmpleado_KPI);
			if(flag)
				return "redirect:/Empleado_KPI/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/empleado_KPI/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Empleado_KPI> objEmpleado_KPI = vService.listarId(id);
		if(objEmpleado_KPI == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/empleado_KPI/listar";
		}
		else {
			if(objEmpleado_KPI.isPresent())
				objEmpleado_KPI.ifPresent(o -> model.addAttribute("Empleado_KPI",o));
			
			return "empleado";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				vService.eliminar(id);
				model.put("listaEmpleado_KPI", vService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaEmpleado_KPI", vService.listar());
		}
		return "listEmpleado_KPI";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaEmpleado_KPI", vService.listar());
		return "listEmpleado_KPI";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Empleado_KPI empleado_KPI) throws ParseException 
	{
		vService.listarId(empleado_KPI.getIdEmpleado_KPI());
		return "listEmpleado_KPI";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("empleado_KPI", new Empleado_KPI());
		return "buscar";
	}
	
	//@RequestMapping("/buscar")
	//public String buscar(Map<String, Object> model, @ModelAttribute Empleado_KPI empleado_KPI) throws ParseException 
	//{
	//	List<Empleado_KPI> listaEmpleado_KPI;
	//	Empleado_KPI.setNombre(empleado_KPI.getNombre());
	//	listaEmpleado_KPI = vService.buscarNombre(empleado_KPI.getNombre());
	//	
	//	if(listaEmpleado_KPI.isEmpty()) {
	//		listaEmpleado_KPI = vService.buscarAnio(empleado_KPI.getNombre());
	//	}
	//	if(listaEmpleado_KPI.isEmpty()) {
	//		listaEmpleado_KPI = vService.buscarMes(empleado_KPI.getNombre());
	//	}
	//	if(listaEmpleado_KPI.isEmpty()) {
	//		listaEmpleado_KPI = vService.buscarEmpleado(empleado_KPI.getNombre());
	//	}
	//	if(listaEmpleado_KPI.isEmpty()) {
	//		listaEmpleado_KPI = vService.buscarKPI(empleado_KPI.getNombre());
	//	}	
	//	if(listaEmpleado_KPI.isEmpty()) {
	//		model.put("mensaje", "No existen coincidencias");
	//	}
	//	
	//	model.put("listaEmpleado_KPI", listaEmpleado_KPI);
	//	return "buscar";
	//}
}
