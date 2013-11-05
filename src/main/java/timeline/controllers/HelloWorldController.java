package timeline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //esto es un controler
@RequestMapping("/hello") //url 
public class HelloWorldController {

	@RequestMapping("/hi") //otra subcarpeta
	public ModelAndView helloWorld(@RequestParam("nombre") String nombre) {

		String message = "Hola, " + nombre + "!";
		return new ModelAndView("hello", "message", message); //adonde va y con que va
	}
	
	@RequestMapping("/hipeople")
	public ModelAndView helloPeople (@RequestParam("mostrar") boolean mostrarAlumnos) {
		String mensaje = "Hola ";
		
		String[] alumnos = {"Alicia", "Damian", "Marcos"};
		
		if (mostrarAlumnos == true) {
			mensaje += alumnos[0] +" , " + alumnos[1] +" , " + alumnos[2];
			mensaje += "!!";
		} else {
			mensaje = "No te saludo";
		}
		
		return new ModelAndView("holas", "mensajejsp", mensaje); //adonde va y con que va
	}
	@RequestMapping("/hilista")
	public ModelAndView holaLista(){
		List <String> lista = new ArrayList <String>();
		lista.add("Marcos");
		lista.add("Damian");
		lista.add("Alicia");
		return new ModelAndView("listaview", "listajsp", lista);
	}
}

