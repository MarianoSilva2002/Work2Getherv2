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

import pe.edu.upc.spring.model.Empresa;

import pe.edu.upc.spring.service.IEmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	
	@Autowired
	private IEmpresaService eService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; //"bienvenido" es una pagina del frontend
	}
	
	@RequestMapping("/")
	public String irPaginaListadoMascotas(Map<String, Object> model) {
		model.put("listaEmpresas", eService.listar());
		return "listEmpresas"; //"listEmpresas" es una pagina del frontend
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("empresa", new Empresa());
		return "empresa"; //"empresa" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Empresa objEmpresa, BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors())
		{
			return "empresa";
		}
		else {
			boolean flag = eService.grabar(objEmpresa);
			if(flag)
				return "redirect:/empresa/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un accidente, LUZ ROJA");
				return "redirect:/empresa/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Empresa> objEmpresa = eService.listarId(id);
		if(objEmpresa == null) {
			objRedir.addFlashAttribute("mensaje","Ocurrio un roche, LUZ ROJA");
			return "redirect:/empresa/listar";
		}
		else {
			if(objEmpresa.isPresent())
				objEmpresa.ifPresent(o -> model.addAttribute("empresa",o));
			
			return "empresa";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				eService.eliminar(id);
				model.put("listaEmpresas", eService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje","Ocurrio un error");
			model.put("listaEmpresas", eService.listar());
		}
		return "listEmpresas";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaEmpresas", eService.listar());
		return "listEmpresas";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Empresa empresa) throws ParseException 
	{
		eService.listarId(empresa.getIdEmpresa());
		return "listEmpresa";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) throws ParseException 
	{
		model.addAttribute("empresa", new Empresa());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Empresa empresa) throws ParseException 
	{
		List<Empresa> listaEmpresas;
		empresa.setNombre(empresa.getNombre());
		listaEmpresas = eService.buscarNombre(empresa.getNombre());
		
		if(listaEmpresas.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}
		
		model.put("listaEmpresas", listaEmpresas);
		return "buscar";
	}
}
