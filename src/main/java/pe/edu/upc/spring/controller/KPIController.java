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

import pe.edu.upc.spring.model.KPI;

import pe.edu.upc.spring.service.IKPIService;

@Controller
@RequestMapping("/kpi")
public class KPIController {

	
	@Autowired
	private IKPIService kService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; //"bienvenido" es una pagina del frontend
	}
	
	@RequestMapping("/")
	public String irPaginaListadoRoles(Map<String, Object> model) {
		model.put("listaKPIs", kService.listar());
		return "listKPIs"; //"listKPIs" es una pagina del frontend...
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("kpi", new KPI());
		return "kpi"; //"kpi" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute KPI objKPI, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			return "kpi";
		}
		else {
			boolean flag = kService.grabar(objKPI);
			if(flag)
				return "redirect:/kpi/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/kpi/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<KPI> objKPI = kService.listarId(id);
		if(objKPI == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/kpi/listar";
		}
		else {
			if(objKPI.isPresent())
				objKPI.ifPresent(o -> model.addAttribute("kpi",o));
			
			return "kpi2";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				kService.eliminar(id);
				model.put("listaKPIs", kService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaKPIs", kService.listar());
		}
		return "listKPIs";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaKPIs", kService.listar());
		return "listKPIs";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute KPI kpi) throws ParseException 
	{
		kService.listarId(kpi.getIdKPI());
		return "listKPIs";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("kpi", new KPI());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute KPI kpi) throws ParseException 
	{
		List<KPI> listaKPIs;
		kpi.setNombre(kpi.getNombre());
		listaKPIs = kService.buscarKPI(kpi.getNombre());
		
		if(listaKPIs.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaKPIs", listaKPIs);
		return "buscar";
	}
}
