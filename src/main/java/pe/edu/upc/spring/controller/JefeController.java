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
import pe.edu.upc.spring.model.Empresa;
import pe.edu.upc.spring.model.Jefe;

import pe.edu.upc.spring.service.IEmpresaService;
import pe.edu.upc.spring.service.IJefeService;
import pe.edu.upc.spring.service.IRolesService;

@Controller
@RequestMapping("/jefe")
public class JefeController {

	@Autowired
	private IEmpresaService eService;
	
	@Autowired
	private IRolesService rService;
	
	@Autowired
	private IJefeService jService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "listJefe"; //"bienvenido" es una pagina del frontend.
	}
	
	@RequestMapping("/")
	public String irPaginaListadoJefes(Map<String, Object> model) {
		model.put("listaJefes", jService.listar());
		return "listJefes"; //"listJefes" es una pagina del frontend.
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaEmpresas", eService.listar());
		model.addAttribute("listaRoles", rService.listar());
		
		model.addAttribute("empresa", new Empresa());
		model.addAttribute("rol", new Roles());
		model.addAttribute("jefe", new Jefe());
		return "jefe"; //"jefe" es una pagina del frontend para insertar y/o modificar.
	}
	
	@RequestMapping("/irInicioSesion")
	public String irPaginaInicioSesion(Model model) {
		model.addAttribute("jefe", new Jefe());
		return "iniciarSesion2"; 
	}
	
	@RequestMapping("/iniciarSesion")
	public String iniciarSesion(@ModelAttribute Empleado objJefe, BindingResult binRes, Model model) throws ParseException{
		List<Jefe> FiltroJefe = jService.buscarContrasena(objJefe.getCorreo(), objJefe.getContrasena());
		if(FiltroJefe.isEmpty())
		{
			return "redirect:/jefe/irInicioSesion";
		}
		else {
			return "listJefe";
		}
		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Jefe objJefe, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			model.addAttribute("listaEmpresas", eService.listar());
			model.addAttribute("listaRoles", rService.listar());
			return "jefe";
		}
		else {
			objJefe.setRol(rService.listarId(1).get());
			boolean flag = jService.grabar(objJefe);
			if(flag)
				return "redirect:/login/";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/jefe/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Jefe> objJefe = jService.listarId(id);
		if(objJefe == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/jefe/listar";
		}
		else {
			if(objJefe.isPresent())
				objJefe.ifPresent(o -> model.addAttribute("jefe",o));
			
			return "jefe";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				jService.eliminar(id);
				model.put("listaJefes", jService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaJefes", jService.listar());
		}
		return "listJefes";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaJefes", jService.listar());
		return "listJefes";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Jefe jefe) throws ParseException 
	{
		jService.listarId(jefe.getIdJefe());
		return "listJefes";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("jefe", new Jefe());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Jefe jefe) throws ParseException 
	{
		List<Jefe> listaJefes;
		jefe.setNombre(jefe.getNombre());
		listaJefes = jService.buscarNombre(jefe.getNombre());
		
		if(listaJefes.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaJefes", listaJefes);
		return "buscar";
	}
}
