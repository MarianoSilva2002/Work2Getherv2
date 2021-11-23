package pe.edu.upc.spring.controller;

import java.util.Date;
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
import pe.edu.upc.spring.model.Mensajes;
import pe.edu.upc.spring.service.IEmpleadoService;
import pe.edu.upc.spring.service.IMensajeService;

@Controller
@RequestMapping("/mensaje")
public class MensajeController {

	
	@Autowired
	private IMensajeService eService;
	
	@Autowired
	private IEmpleadoService emService;
	
	private int idEmpleado;
	
	@RequestMapping("/Jefe")
	public String irPaginaJefe(Map<String, Object> model) {
		model.put("listMensajes", eService.mensajesEmpleadoyJefe(ActividadController.EmpleadoCActiva.getIdEmpleado()));
		model.put("jefe", ActividadController.EmpleadoCActiva.getJefe());
		return "Mensajeria_Jefe"; //"bienvenido" es una pagina del frontend.
	}
	@RequestMapping("/Empleado/{id}")
	public String irPaginaEmpleado(Map<String, Object> model, @PathVariable int id) {
		idEmpleado=id;
		model.put("listMensajes", eService.mensajesEmpleadoyJefe(id));
		model.put("jefe", ActividadController.JefeCActiva);
		return "Mensajeria_Empleado"; //"bienvenido" es una pagina del frontend.
	}
	
	@RequestMapping("/Enviar_Jefe")
	public String irPaginaMensaje(Model model) {
		model.addAttribute("mensaje", new Mensajes());
		return "Mensaje_Jefe"; //"bienvenido" es una pagina del frontend.
	}
	@RequestMapping("/Enviar_Empleado")
	public String irPaginaJefe(Model model) {
		model.addAttribute("mensaje", new Mensajes());
		return "Mensaje_Empleado"; //"bienvenido" es una pagina del frontend.
	}
	
	@RequestMapping("/")
	public String irPaginaListadoMascotas(Map<String, Object> model) {
		model.put("listaMensajes", eService.listar());
		return "listMensajes"; //"listMensajes" es una pagina del frontend.
	}
	
	@RequestMapping("/registrarMensajeJefe")
	public String registrarMensajeJefe(@ModelAttribute Mensajes objMensaje, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			return "mensaje";
		}
		else {
			Date fechaactual= new Date();
			objMensaje.setFechaMensaje(fechaactual);
			objMensaje.setEmpleado(ActividadController.EmpleadoCActiva);
			objMensaje.setEmisor_correo(ActividadController.EmpleadoCActiva.getCorreo());
			objMensaje.setReceptor_correo(ActividadController.EmpleadoCActiva.getJefe().getCorreo());
			boolean flag = eService.grabar(objMensaje);
			if(flag)
				return "redirect:/mensaje/Jefe";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/mensaje/Enviar_Jefe";
			}
		}
	}
	
	@RequestMapping("/registrarMensajeEmpleado")
	public String registrarMensajeEmpleado(@ModelAttribute Mensajes objMensaje, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			return "mensaje";
		}
		else {
			Date fechaactual= new Date();
			objMensaje.setFechaMensaje(fechaactual);
			Optional<Empleado> objEmpleado= emService.listarId(idEmpleado);
			objMensaje.setEmpleado(objEmpleado.get());
			objMensaje.setReceptor_correo(objEmpleado.get().getCorreo());
			objMensaje.setEmisor_correo(ActividadController.JefeCActiva.getCorreo());
			boolean flag = eService.grabar(objMensaje);
			if(flag)
			{
				return "redirect:/jefe/empleados";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/mensaje/Enviar_Empleado";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Mensajes> objMensaje = eService.listarId(id);
		if(objMensaje == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/mensaje/Empleado";
		}
		else {
			if(objMensaje.isPresent())
				objMensaje.ifPresent(o -> model.addAttribute("mensaje",o));
			
			return "mensaje";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				eService.eliminar(id);
				model.put("listaMensajes", eService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaMensajes", eService.listar());
		}
		return "listMensajes";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaMensajes", eService.listar());
		return "listEMensajes";
	}
	
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Mensajes mensaje) throws ParseException 
	{
		eService.listarId(mensaje.getIdMensaje());
		return "listMensaje";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("mensaje", new Mensajes());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Mensajes mensaje) throws ParseException 
	{
		List<Mensajes> listaMensajes;
		mensaje.setMensaje(mensaje.getMensaje());
		listaMensajes = eService.buscarMensaje(mensaje.getMensaje());
		
		if(listaMensajes.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaMensajes", listaMensajes);
		return "buscar";
	}
}
