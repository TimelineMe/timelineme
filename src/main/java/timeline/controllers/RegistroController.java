package timeline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/paginas") 
public class RegistroController {

	@RequestMapping("/registro") 
	public ModelAndView AltaEmpresa() {
		return new ModelAndView("altaagente");
	}
}