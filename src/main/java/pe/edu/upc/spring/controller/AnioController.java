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

import pe.edu.upc.spring.model.Anio;
import pe.edu.upc.spring.service.IAnioService;

@Controller
@RequestMapping("/anio")
public class AnioController {

	
	@Autowired
	private IAnioService aService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; //"bienvenido" es una pagina del frontend
	}
	
	@RequestMapping("/")
	public String irPaginaListadoAnio(Map<String, Object> model) {
		model.put("listaAnio", aService.listar());
		return "listAnio"; //"listAnio" es una pagina del frontend
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("anio", new Anio());
		return "anio"; //"anio" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Anio objAnio, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			return "anio";
		}
		else {
			boolean flag = aService.grabar(objAnio);
			if(flag)
				return "redirect:/anio/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/anio/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Anio> objAnio = aService.listarId(id);
		if(objAnio == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/anio/listar";
		}
		else {
			if(objAnio.isPresent())
				objAnio.ifPresent(o -> model.addAttribute("anio",o));
			
			return "anio";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				aService.eliminar(id);
				model.put("listaAnio", aService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaAnio", aService.listar());
		}
		return "listAnio";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaAnio", aService.listar());
		return "listAnio";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Anio anio) throws ParseException 
	{
		aService.listarId(anio.getIdAnio());
		return "listAnio";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("anio", new Anio());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Anio anio) throws ParseException 
	{
		List<Anio> listaAnio;
		anio.setAnio(anio.getAnio());
		listaAnio = aService.buscarAnio(anio.getAnio());
		
		if(listaAnio.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaAnio", listaAnio);
		return "buscar";
	}
}
