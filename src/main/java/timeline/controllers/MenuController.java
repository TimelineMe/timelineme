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
	public ModelAndView BienvenidoAgente(){
		return new ModelAndView("bienvenidoagente");
	}
	@RequestMapping("/buscador")
	public ModelAndView Buscador(HttpSession session,@RequestParam("palabra") String palabra) throws PersistenceException {
		ModelAndView mavResultadosEmpresas = new ModelAndView(
				"resultadosbusqueda");
		Agente agente = (Agente) session.getAttribute("agente");
		List<Empresa> misEmpresas = empresaService.findEmpresasQueSigoByPalabra(agente.getEmail_Agente(), palabra);
		List<Empresa> empresasNoSeguidas = empresaService.findEmpresasQueNoSigoByPalabra(agente.getEmail_Agente(), palabra);
		mavResultadosEmpresas.addObject("misEmpresas", misEmpresas);
		mavResultadosEmpresas.addObject("empresasNoSeguidas", empresasNoSeguidas);
		return mavResultadosEmpresas;
	}

	@RequestMapping("/crearnoticia")
	public ModelAndView CrearNoticia() {
		return new ModelAndView("crearnoticia");
	}
	
	@RequestMapping("/insertarnoticia")
	public ModelAndView InsertarNoticia(HttpSession session, @RequestParam("titulo") String titulo, @RequestParam("contenido") String contenido)
			throws PersistenceException {
			ModelAndView mavCrearNoticia = new ModelAndView("crearnoticia");
			Agente agente = (Agente) session.getAttribute("agente");
			noticiaService.insertarNoticia(titulo, contenido, agente.getEmail_Agente());
			String mensaje = "La noticia se envió correctamente.";
			mavCrearNoticia.addObject("mensaje", mensaje);
			return mavCrearNoticia;
	}
	
	@RequestMapping("/noticia")
	public ModelAndView Noticia (@RequestParam("id") Integer id) throws PersistenceException {
		ModelAndView mavNoticia = new ModelAndView("noticia");
		Noticia noticia = noticiaService.findbyID(id);
		mavNoticia.addObject("noticia",noticia);
		return mavNoticia;
	}

	@RequestMapping("/empresasquesigo")
	public ModelAndView EmpresasQueSigo(HttpSession session)
			throws PersistenceException {
		ModelAndView mavPerfilAgente = new ModelAndView("empresasquesigo");
		Agente agente = (Agente) session.getAttribute("agente");
		List<Empresa> misEmpresasSeguidas = empresaService
				.findEmpresasSeguidasByAgente(agente.getEmail_Agente());
		mavPerfilAgente.addObject("misEmpresasSeguidas", misEmpresasSeguidas);
		return mavPerfilAgente;
	}

	@RequestMapping("/notificaciones")
	public ModelAndView Notificaciones(HttpSession session)
			throws PersistenceException {
		ModelAndView mavNotificaciones = new ModelAndView("notificaciones");
		Agente agente = (Agente) session.getAttribute("agente");
		List<Noticia> noticiasSeguidas = noticiaService
				.findNoticiasByEmpresaSeguida(agente.getEmail_Agente());
		mavNotificaciones.addObject("noticiasSeguidas", noticiasSeguidas);
		return mavNotificaciones;
	}

	@RequestMapping("/perfilagente")
	public ModelAndView PerfilAgente(HttpSession session)
			throws PersistenceException {
		ModelAndView mavPerfilAgente = new ModelAndView("perfilagente");
		Agente miAgente = (Agente) session.getAttribute("agente");
		List<Noticia> misNoticias = noticiaService.findbyAutor(miAgente.getEmail_Agente());	
		String emailEmpresa = miAgente.getEmpresa();
		Empresa miEmpresa = empresaService.findByEmail(emailEmpresa);
		mavPerfilAgente.addObject("miAgente", miAgente);
		mavPerfilAgente.addObject("miEmpresa", miEmpresa);
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

	@RequestMapping("/timeline")
	public ModelAndView timeline(@RequestParam("empresa") String email) throws PersistenceException {
		
		ModelAndView mavTimelineEmpresa = new ModelAndView("timeline");
		Empresa miEmpresa = empresaService.findByEmail(email);
		String emailEmpresa = miEmpresa.getEmail();
		List<Noticia> misNoticias = noticiaService.findbyEmpresa(emailEmpresa);
		List <Agente> misSeguidores = agenteService.findSeguidoresByEmpresa(emailEmpresa);
		mavTimelineEmpresa.addObject("miEmpresa", miEmpresa);
		mavTimelineEmpresa.addObject("misNoticias", misNoticias);
		mavTimelineEmpresa.addObject("misSeguidores", misSeguidores);
		return mavTimelineEmpresa;
	}
	
	@RequestMapping("/seguir")
	public ModelAndView seguirEmpresa(HttpSession session,@RequestParam("empresa") String emailEmpresa)
			throws PersistenceException {
		ModelAndView mavSeguirEmpresa = new ModelAndView("empresasquesigo");
		Agente agente = (Agente) session.getAttribute("agente");
		//llama al servicio para agregar la empresa a las que sigo
		agenteEmpresaService.seguirEmpresa(emailEmpresa, agente.getEmail_Agente());
		//busca en la base las empresas que sigo y las muestra
		List<Empresa> misEmpresasSeguidas = empresaService.findEmpresasSeguidasByAgente(agente.getEmail_Agente());
		//vuelvo a cargar las noticias a la sesion
		List <Noticia> noticiasSeguidas = noticiaService.findNoticiasByEmpresaSeguida(agente.getEmail_Agente());
		session.setAttribute("novedades", noticiasSeguidas.size());
		mavSeguirEmpresa.addObject("misEmpresasSeguidas", misEmpresasSeguidas);
		return mavSeguirEmpresa;
	}
	
	@RequestMapping("/dejardeseguir")
	public ModelAndView dejarSeguirEmpresa(HttpSession session,@RequestParam("empresa") String emailEmpresa)
			throws PersistenceException {
		Agente agente = (Agente) session.getAttribute("agente");
		agenteEmpresaService.dejarSeguirEmpresa(emailEmpresa, agente.getEmail_Agente());
		ModelAndView mavSeguirEmpresa = new ModelAndView("empresasquesigo");
		List<Empresa> misEmpresasSeguidas = empresaService.findEmpresasSeguidasByAgente(agente.getEmail_Agente());
		mavSeguirEmpresa.addObject("misEmpresasSeguidas", misEmpresasSeguidas);
		List <Noticia> noticiasSeguidas = noticiaService.findNoticiasByEmpresaSeguida(agente.getEmail_Agente());
		session.setAttribute("novedades", noticiasSeguidas.size());
		return mavSeguirEmpresa;
	}
}

