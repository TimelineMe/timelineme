package timeline.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import timeline.model.Agente;
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
			List<Empresa> misEmpresasSeguidas = agenteEmpresaService.findByAgente(email);
			mavPerfilAgente.addObject("misEmpresasSeguidas", misEmpresasSeguidas);
			return mavPerfilAgente;
	}

	@RequestMapping("/notificaciones")
	public ModelAndView Notificaciones(HttpSession session) throws PersistenceException {
		ModelAndView mavNotificaciones = new ModelAndView("notificaciones");
		
		String email = (String) session.getAttribute("agente");
		List <Noticia> noticiasSeguidas = agenteEmpresaService.findNoticiasByAgente(email);
		Integer novedades = noticiasSeguidas.size();
		mavNotificaciones.addObject("noticiasSeguidas", noticiasSeguidas);
		mavNotificaciones.addObject("novedades", novedades);
		return mavNotificaciones;
	}

	@RequestMapping("/perfilagente")
	public ModelAndView PerfilAgente(HttpSession session)
			throws PersistenceException {
		ModelAndView mavPerfilAgente = new ModelAndView("perfilagente");
		
		String email = (String) session.getAttribute("agente");
		List<Noticia> misNoticias = noticiaService.findbyAutor(email);
		Agente miAgente = agenteService.findByEmail(email);
				
		String emailEmpresa = miAgente.getEmpresa();
		Empresa miEmpresa = empresaService.findByEmail(emailEmpresa);
		
		mavPerfilAgente.addObject("miEmpresa", miEmpresa);
		mavPerfilAgente.addObject("miAgente", miAgente);
		mavPerfilAgente.addObject("misNoticias", misNoticias);
		return mavPerfilAgente;
	}
	
	@RequestMapping("/perfilautor")
	public ModelAndView PerfilAutor(@RequestParam("emailAgente") String emailAgente) throws PersistenceException {
		ModelAndView mavPerfilAutor = new ModelAndView("perfilagente");
		String email = emailAgente;
		List<Noticia> misNoticias = noticiaService.findbyAutor(email);
		Agente miAgente = agenteService.findByEmail(email);
		String emailEmpresa = miAgente.getEmpresa();
		Empresa miEmpresa = empresaService.findByEmail(emailEmpresa);
		mavPerfilAutor.addObject("miEmpresa", miEmpresa);
		mavPerfilAutor.addObject("miAgente", miAgente);
		mavPerfilAutor.addObject("misNoticias", misNoticias);
		return mavPerfilAutor;
	}

	@RequestMapping("/resultadosbusqueda")
	public ModelAndView resultadosbusqueda() throws PersistenceException {
		
		ModelAndView mavResultadosEmpresas = new ModelAndView(
				"resultadosbusqueda");
		
		List<Empresa> misEmpresas = empresaService.findAllEmpresas();
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
		List <Agente> misSeguidores = agenteEmpresaService.findByEmpresa(pemailEmpresa);
		mavTimelineEmpresa.addObject("miEmpresa", miEmpresa);
		mavTimelineEmpresa.addObject("misNoticias", misNoticias);
		mavTimelineEmpresa.addObject("misSeguidores", misSeguidores);
		return mavTimelineEmpresa;
	}
}