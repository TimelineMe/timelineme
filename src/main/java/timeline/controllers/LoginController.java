package timeline.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import timeline.persistence.PersistenceException;
import timeline.services.AgenteEmpresaService;
import timeline.services.LoginService;
@Controller
@RequestMapping("/paginas")
@SessionAttributes("agente")
public class LoginController {

	LoginService loginService = new LoginService();
	AgenteEmpresaService agenteEmpresaService = new AgenteEmpresaService();

	@RequestMapping("/login")
	public ModelAndView authenticate(
			@RequestParam("email") String email,
			@RequestParam("password") String password) throws PersistenceException{

		ModelAndView reenvio = null;

		if (loginService.validar(email, password)) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("agente", email);
			modelAndView.setViewName("bienvenidoagente");
			return modelAndView;
		} else {
			reenvio = new ModelAndView("index2", "mensaje", "Contraseņa incorrecta, o usuario no valido");
		}

		return reenvio;

	}
	@RequestMapping("/logout")
	public ModelAndView Logout() {
		return new ModelAndView("index2","mensaje","Estas deslogueado. Para volver a ingresar al sitio, tendras que loguearte de nuevo.");
	}

}

