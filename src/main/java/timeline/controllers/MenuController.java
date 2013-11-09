package timeline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/paginas") 
public class MenuController {

	@RequestMapping("/altaagente") 
	public ModelAndView AltaAgente() {
		return new ModelAndView("altaagente");
	}
	@RequestMapping("/bienvenidoagente") 
	public ModelAndView BienvenidoAgente() {
		return new ModelAndView("bienvenidoagente");
	}
	@RequestMapping("/crearnoticia") 
	public ModelAndView CrearAgente() {
		return new ModelAndView("crearnoticia");
	}
	@RequestMapping("/empresasquesigo") 
	public ModelAndView EmpresasQueSigo() {
		return new ModelAndView("empresasquesigo");
	}
	@RequestMapping("/notificaciones") 
	public ModelAndView Notificaciones() {
		return new ModelAndView("notificaciones");
	}
	@RequestMapping("/perfilagente") 
	public ModelAndView PerfilAgente() {
		return new ModelAndView("perfilagente");
	}
	@RequestMapping("/resultadosbusqueda") 
	public ModelAndView ResultadosBusqueda() {
		return new ModelAndView("resultadosbusqueda");
	}
	@RequestMapping("/timeline") 
	public ModelAndView TimelineAgente() {
		return new ModelAndView("timeline");
	}
}