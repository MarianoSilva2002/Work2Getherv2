package pe.edu.upc.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.model.Empleado;
import pe.edu.upc.spring.model.Empresa;
import pe.edu.upc.spring.model.Jefe;
import pe.edu.upc.spring.model.Roles;
import pe.edu.upc.spring.service.IEmpleadoService;
import pe.edu.upc.spring.service.IEmpresaService;
import pe.edu.upc.spring.service.IJefeService;
import pe.edu.upc.spring.service.IRolesService;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	private IJefeService jService;
	
	@Autowired
	private IRolesService rService;
	
	@Autowired
	private IEmpleadoService aService;
	
	@Autowired
	private IEmpresaService eService;
	
	@GetMapping("/")
	public String login() {
		return "bienvenido";
	}
	
	@RequestMapping("/registro")
	public String irPaginaRegistrarComo(Map<String, Object> model) {
		model.put("listaEmpleados", jService.listar());
		return "login"; //"listEmpleados" es una pagina del frontend...
	}
	
	@RequestMapping("/iniciarSesion")
	public String irPaginaIniciarSesion(Map<String, Object> model) {
		model.put("listaEmpleados", jService.listar());
		return "login2"; //"listEmpleados" es una pagina del frontend...
	}
		
	@RequestMapping("/irRegistrarEmpleado")
	public String irPaginaRegistrarEmpleado(Model model) {
		model.addAttribute("listaJefes", jService.listar());
		model.addAttribute("listaRoles", rService.listar());
		
		model.addAttribute("jefe", new Jefe());
		model.addAttribute("rol", new Roles());
		model.addAttribute("empleado", new Empleado());
		return "Empleado"; //"Empleado" es una pagina del frontend para insertar y/o modificar
	}
	
	@RequestMapping("/irRegistrarJefe")
	public String irPaginaRegistrarJefe(Model model) {
		model.addAttribute("listaEmpresas", eService.listar());
		model.addAttribute("listaRoles", rService.listar());
		
		model.addAttribute("empresa", new Empresa());
		model.addAttribute("rol", new Roles());
		model.addAttribute("jefe", new Jefe());
		return "jefe"; //"jefe" es una pagina del frontend para insertar y/o modificar.
	}
}
