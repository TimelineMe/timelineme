package timeline.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import timeline.model.Agente;
import timeline.model.AgenteEmpresa;
import timeline.model.Empresa;
import timeline.model.Noticia;
import timeline.persistence.PersistenceException;
import timeline.services.AgenteEmpresaService;
import timeline.services.AgenteService;
import timeline.services.EmpresaService;
import timeline.services.NoticiaService;

@Controller
@SessionAttributes("agente")
@RequestMapping("/paginas") 
public class MenuController {
	EmpresaService empresaService = new EmpresaService();
	AgenteService agenteService = new AgenteService();
	NoticiaService noticiaService = new NoticiaService();
	AgenteEmpresaService agenteEmpresaService = new AgenteEmpresaService();
	
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
	
	public ModelAndView EmpresasQueSigo(HttpSession session)
			throws PersistenceException {
		ModelAndView mavPerfilAgente = new ModelAndView("empresasquesigo");
			
			String email = (String) session.getAttribute("agente");
			List<AgenteEmpresa> misEmpresasSeguidas = agenteEmpresaService.findByAgente(email);
			
			mavPerfilAgente.addObject("misEmpresasSeguidas", misEmpresasSeguidas);
			
			return mavPerfilAgente;
	}

	@RequestMapping("/notificaciones")
	public ModelAndView Notificaciones() {
		return new ModelAndView("notificaciones");
	}

	@RequestMapping("/perfilagente")
	public ModelAndView PerfilAgente(HttpSession session)
			throws PersistenceException {
		ModelAndView mavPerfilAgente = new ModelAndView("perfilagente");
		
		String email = (String) session.getAttribute("agente");
		Agente miAgente = agenteService.findByEmail(email);
		
		String emailEmpresa = miAgente.getEmpresa();
		Empresa miEmpresa = empresaService.findByEmail(emailEmpresa);
		
		mavPerfilAgente.addObject("miEmpresa", miEmpresa);
		mavPerfilAgente.addObject("miAgente", miAgente);
		
		return mavPerfilAgente;
	}

	@RequestMapping("/resultadosbusqueda")
	public ModelAndView resultadosbusqueda() throws PersistenceException {
		
		ModelAndView mavResultadosEmpresas = new ModelAndView(
				"resultadosbusqueda");
		
		List<Empresa> misEmpresas = empresaService.findAllEmpresas();
		//agrego objetos para enviar
		mavResultadosEmpresas.addObject("misEmpresas", misEmpresas);
		
		return mavResultadosEmpresas;
	}

	@RequestMapping("/timeline")
	public ModelAndView timeline(@RequestParam("empresa") String emailEmpresa) throws PersistenceException {
		
		ModelAndView mavTimelineEmpresa = new ModelAndView(
				"timeline");
		
		Empresa miEmpresa = empresaService.findByEmail(emailEmpresa);
		String pemailEmpresa = miEmpresa.getEmail();
		List<Noticia> misNoticias = noticiaService.findbyEmpresa(pemailEmpresa);
		mavTimelineEmpresa.addObject("miEmpresa", miEmpresa);
		mavTimelineEmpresa.addObject("misNoticias", misNoticias);
		return mavTimelineEmpresa;
	}
}