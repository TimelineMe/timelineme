package timeline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import timeline.services.EmpresaService;


@Controller 
@RequestMapping("/paginas") 
public class RegistroController {
	EmpresaService empresaService = new EmpresaService();
	
	@RequestMapping("/registro") 
	public ModelAndView AltaEmpresa(
			@RequestParam("email") String email, 
			@RequestParam("password") String password, 
			@RequestParam("razon_Social") String razon_Social,
			@RequestParam("sitio_Web") String sitio_Web,
			@RequestParam("direccion") String direccion,
			@RequestParam("telefono") String telefono
			) {
		
		return new ModelAndView("altaagente");
	}
}