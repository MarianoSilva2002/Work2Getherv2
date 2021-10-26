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

import pe.edu.upc.spring.model.Mes;
import pe.edu.upc.spring.service.IMesService;

@Controller
@RequestMapping("/mes")
public class MesController {

	
	@Autowired
	private IMesService mService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; //"bienvenido" es una pagina del frontend
	}
	
	@RequestMapping("/")
	public String irPaginaListadoMes(Map<String, Object> model) {
		model.put("listaMes", mService.listar());
		return "listMes"; //"listMes" es una pagina del frontend
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("mes", new Mes());
		return "mes"; //"mes" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Mes objMes, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			return "mes";
		}
		else {
			boolean flag = mService.grabar(objMes);
			if(flag)
				return "redirect:/mes/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/empresa/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Mes> objMes = mService.listarId(id);
		if(objMes == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/mes/listar";
		}
		else {
			if(objMes.isPresent())
				objMes.ifPresent(o -> model.addAttribute("mes",o));
			
			return "mes";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				mService.eliminar(id);
				model.put("listaMes", mService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaMes", mService.listar());
		}
		return "listMes";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaMes", mService.listar());
		return "listMes";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Mes mes) throws ParseException 
	{
		mService.listarId(mes.getIdMes());
		return "listMes";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("mes", new Mes());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Mes mes) throws ParseException 
	{
		List<Mes> listaMes;
		mes.setMes(mes.getMes());
		listaMes = mService.buscarMes(mes.getMes());
		
		if(listaMes.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaMes", listaMes);
		return "buscar";
	}
}
