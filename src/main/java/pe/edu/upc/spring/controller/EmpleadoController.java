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

import pe.edu.upc.spring.model.Roles;
import pe.edu.upc.spring.model.Empleado;
import pe.edu.upc.spring.model.Jefe;

import pe.edu.upc.spring.service.IJefeService;
import pe.edu.upc.spring.service.IEmpleadoService;
import pe.edu.upc.spring.service.IRolesService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private IJefeService eService;
	
	@Autowired
	private IRolesService rService;
	
	@Autowired
	private IEmpleadoService jService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; //"bienvenido" es una pagina del frontend...
	}
	
	@RequestMapping("/")
	public String irPaginaListadoEmpleados(Map<String, Object> model) {
		model.put("listaEmpleados", jService.listar());
		return "listEmpleados"; //"listEmpleados" es una pagina del frontend...
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaJefes", eService.listar());
		model.addAttribute("listaRoles", rService.listar());
		
		model.addAttribute("jefe", new Jefe());
		model.addAttribute("rol", new Roles());
		model.addAttribute("empleado", new Empleado());
		return "Empleado"; //"Empleado" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Empleado objEmpleado, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			model.addAttribute("listaJefes", eService.listar());
			model.addAttribute("listaRoles", rService.listar());
			return "empleado";
		}
		else {
			boolean flag = jService.grabar(objEmpleado);
			if(flag)
				return "redirect:/empleado/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/empleado/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Empleado> objEmpleado = jService.listarId(id);
		if(objEmpleado == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/empleado/listar";
		}
		else {
			if(objEmpleado.isPresent())
				objEmpleado.ifPresent(o -> model.addAttribute("empleado",o));
			
			return "empleado";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				jService.eliminar(id);
				model.put("listaEmpleados", jService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaEmpleados", jService.listar());
		}
		return "listEmpleados";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaEmpleados", jService.listar());
		return "listEmpleados";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Empleado empleado) throws ParseException 
	{
		jService.listarId(empleado.getIdEmpleado());
		return "listEmpleados";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("empleado", new Empleado());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Empleado empleado) throws ParseException 
	{
		List<Empleado> listaEmpleados;
		empleado.setNombre(empleado.getNombre());
		listaEmpleados = jService.buscarNombre(empleado.getNombre());
		
		if(listaEmpleados.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaEmpleados", listaEmpleados);
		return "buscar";
	}
}
