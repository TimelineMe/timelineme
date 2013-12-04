package timeline.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import timeline.model.Agente;
import timeline.model.Noticia;
import timeline.persistence.PersistenceException;
import timeline.services.LoginService;
import timeline.services.AgenteService;
import timeline.services.NoticiaService;

@Controller
@RequestMapping("/paginas")
@SessionAttributes({"agente","novedades"})
public class LoginController {

	LoginService loginService = new LoginService();
	AgenteService agenteService = new AgenteService();
	NoticiaService noticiaService = new NoticiaService();

	@RequestMapping("/login")
	public ModelAndView autenticacion(
			@RequestParam("email") String email,
			@RequestParam("password") String password) throws PersistenceException{

		ModelAndView reenvio = null;

		if (loginService.validar(email, password)) {
			ModelAndView modelAndView = new ModelAndView();
			//trae un objeto agente 
			Agente agente = agenteService.findByEmail(email);
			//cuenta la cantidad de noticias que tiene y guarda la cantidad en novedades
			List <Noticia> noticiasSeguidas = noticiaService.findNoticiasByEmpresaSeguida(email);
			Integer novedades = noticiasSeguidas.size();
			modelAndView.addObject("agente", agente);
			modelAndView.addObject("novedades", novedades);
			modelAndView.setViewName("bienvenidoagente");
			return modelAndView;
		} else {
			reenvio = new ModelAndView("index2", "mensaje", "Contraseña incorrecta, o usuario no valido");
		}

		return reenvio;
	}
	@RequestMapping("/logout")
	public ModelAndView Logout() {
		return new ModelAndView("index2","mensaje","Estas deslogueado. Para volver a ingresar al sitio, tendras que loguearte de nuevo.");
	}

}

