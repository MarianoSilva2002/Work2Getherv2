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

import pe.edu.upc.spring.service.IRolesService;

@Controller
@RequestMapping("/rol")
public class RolesController {

	
	@Autowired
	private IRolesService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; //"bienvenido" es una pagina del frontend
	}
	
	@RequestMapping("/")
	public String irPaginaListadoRoles(Map<String, Object> model) {
		model.put("listaRoles", rService.listar());
		return "listRoles"; //"listRoles" es una pagina del frontend
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("rol", new Roles());
		return "rol"; //"rol" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Roles objRol, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			return "rol";
		}
		else {
			boolean flag = rService.grabar(objRol);
			if(flag)
				return "redirect:/rol/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/rol/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Roles> objRol = rService.listarId(id);
		if(objRol == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/rol/listar";
		}
		else {
			if(objRol.isPresent())
				objRol.ifPresent(o -> model.addAttribute("rol",o));
			
			return "rol";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaRoles", rService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaRoles", rService.listar());
		}
		return "listRoles";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaRoles", rService.listar());
		return "listRoles";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Roles rol) throws ParseException 
	{
		rService.listarId(rol.getIdRol());
		return "listRoles";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("rol", new Roles());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Roles rol) throws ParseException 
	{
		List<Roles> listaRoles;
		rol.setNombre(rol.getNombre());
		listaRoles = rService.buscarNombre(rol.getNombre());
		
		if(listaRoles.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaRoles", listaRoles);
		return "buscar";
	}
}
