package timeline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import timeline.persistence.PersistenceException;
import timeline.services.LoginService;
@Controller
@RequestMapping("/paginas")
public class LoginController {

	LoginService loginService = new LoginService();

	@RequestMapping("/login")
	public ModelAndView authenticate(
			@RequestParam("email") String email,
			@RequestParam("password") String password) throws PersistenceException{

		ModelAndView dispatch = null;

		if (loginService.validar(email, password)) {
			dispatch = new ModelAndView("altaagente", "empresa", email); 
		} else {
			dispatch = new ModelAndView("../../index", "mensaje", "Contraseña incorrecta, o usuario no valido");
		}

		return dispatch;

	}

}

