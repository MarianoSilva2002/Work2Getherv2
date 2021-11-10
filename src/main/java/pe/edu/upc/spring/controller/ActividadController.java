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

import pe.edu.upc.spring.model.Actividad;
import pe.edu.upc.spring.model.Empleado;
import pe.edu.upc.spring.model.TiempoActividad;

import pe.edu.upc.spring.service.IActividadService;
import pe.edu.upc.spring.service.IEmpleadoService;
import pe.edu.upc.spring.service.ITiempoActividadService;

@Controller
@RequestMapping("/actividad")
public class ActividadController {
	
	@Autowired
	private IEmpleadoService eService;
	
	@Autowired
	private ITiempoActividadService taService;
	
	@Autowired
	private IActividadService aService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; //"bienvenido" es una pagina del frontend
	}
	@RequestMapping("/NActividad")
	public String NActicidad() {
		return "No_Actividades"; //"bienvenido" es una pagina del frontend
	}
	@RequestMapping("/NActividad2")
	public String NActicidad2() {
		return "No_Actividades_2"; //"bienvenido" es una pagina del frontend
	}
	@RequestMapping("/ARealizadas")
	public String ARealizadas(Map<String, Object> model) {
		model.put("listaActividades", aService.listar());
		return "Actividades_Realizadas"; //"bienvenido" es una pagina del frontend
	}
	@RequestMapping("/APendientes")
	public String APendientes(Map<String, Object> model) {
		model.put("listaActividades", aService.listar());
		return "Actividades_Pendientes"; //"bienvenido" es una pagina del frontend
	}
	@RequestMapping("/")
	public String irPaginaListadoJefes(Map<String, Object> model) {
		model.put("listaActividades", aService.listar());
		return "listActividades"; //"listActividades" es una pagina del frontend
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaEmpleados", eService.listar());
		model.addAttribute("listaTiempoActividad", taService.listar());
		
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("tiempoactividad", new TiempoActividad());
		model.addAttribute("actividad", new Actividad());
		return "actividad"; //"actividad" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Actividad objActividad, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			model.addAttribute("listaEmpleados", eService.listar());
			model.addAttribute("listaTiempoActividad", taService.listar());
			return "actividad";
		}
		else {
			TiempoActividad ta = new TiempoActividad();
			taService.grabar(ta);
			objActividad.setTiempo(taService.listar().get(taService.listar().size()-1));
			objActividad.setEstado("Pendiente");
			System.out.println(objActividad.getEmpleado().getNombre());
			boolean flag = aService.grabar(objActividad);
			if(flag)
				return "redirect:/actividad/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/actividad/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Actividad> objActividad = aService.listarId(id);
		if(objActividad == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/actividad/listar";
		}
		else {
			model.addAttribute("listaEmpleados", eService.listar());
			model.addAttribute("listaTiempoActividad", taService.listar());
			if(objActividad.isPresent())				
				objActividad.ifPresent(o -> model.addAttribute("actividad",o));
			
			return "actividad2";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				aService.eliminar(id);
				model.put("listaActividades", aService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaActividades", aService.listar());
		}
		return "listActividades";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaActividades", aService.listar());
		return "listActividades";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Actividad actividad) throws ParseException 
	{
		aService.listarId(actividad.getIdActividad());
		return "listActividades";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("actividad", new Actividad());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Actividad actividad) throws ParseException 
	{
		List<Actividad> listaActividades;
		actividad.setNombre(actividad.getNombre());
		listaActividades = aService.buscarNombre(actividad.getNombre());
		
		if(listaActividades.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaActividades", listaActividades);
		return "buscar";
	}
}
