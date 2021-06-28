package ar.edu.unju.fi.tpfinal.controller;
/**
 * author CGRS
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Esta anotacion @Controller indica que tiene pequeaas tareas derivada de la clase controller.
 * Aqui se responde a la interacción (eventos) que hace el usuario en la interfaz 
 * y realiza las peticiones necesarias (a la interfaces, clases,etc) para obtener lo que pide la vista.
 * 
 */
@Controller
public class HomeController {
	/**
	 * Metodo GetMapping.
	 * @return login 
	 */
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    /**
     * Metodo GetMapping.
     * @return forbidden
     */
    @GetMapping("/forbidden")
    public String forbidden(){
        return "forbidden";
    }
}
