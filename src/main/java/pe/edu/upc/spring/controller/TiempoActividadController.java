package pe.edu.upc.spring.controller;

//import java.util.List;
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

import pe.edu.upc.spring.model.TiempoActividad;

import pe.edu.upc.spring.service.ITiempoActividadService;

@Controller
@RequestMapping("/tiempoactividad")
public class TiempoActividadController {

	
	@Autowired
	private ITiempoActividadService taService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; //"bienvenido" es una pagina del frontend
	}
	
	@RequestMapping("/")
	public String irPaginaListadoRoles(Map<String, Object> model) {
		model.put("listaTiempoActividad", taService.listar());
		return "listTiempoActividad"; //"listTiempoActividad" es una pagina del frontend
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("tiempoactividad", new TiempoActividad());
		return "tiempoactividad"; //"tiempoactividad" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute TiempoActividad objTiempoActividad, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			return "tiempoactividad";
		}
		else {
			boolean flag = taService.grabar(objTiempoActividad);
			if(flag)
				return "redirect:/tiempoactividad/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/tiempoactividad/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<TiempoActividad> objTiempoActividad = taService.listarId(id);
		if(objTiempoActividad == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/tiempoactividad/listar";
		}
		else {
			if(objTiempoActividad.isPresent())
				objTiempoActividad.ifPresent(o -> model.addAttribute("tiempoactividad",o));
			
			return "tiempoactividad";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				taService.eliminar(id);
				model.put("listaTiempoActividad", taService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaTiempoActividad", taService.listar());
		}
		return "listTiempoActividad";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTiempoAcividad", taService.listar());
		return "listTiempoActividad";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute TiempoActividad rol) throws ParseException 
	{
		taService.listarId(rol.getIdTiempoActividad());
		return "listTiempoActividad";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("tiempoactividad", new TiempoActividad());
		return "buscar";
	}
	
	//@RequestMapping("/buscar")
	//public String buscar(Map<String, Object> model, @ModelAttribute TiempoActividad tiempoactividad) throws ParseException 
	//{
	//	List<TiempoActividad> listaTiempoActividad;
	//	tiempoactividad.setNombre(tiempoactividad.getNombre());
	//	listaTiempoActividad = rService.buscarNombre(rol.getNombre());
	//	
	//	if(listaRoles.isEmpty()) {
	//		model.put("mensaje", "No existen coincidencias");
	//	}
	//	
	//	model.put("listaRoles", listaRoles);
	//	return "buscar";
	//}
}
