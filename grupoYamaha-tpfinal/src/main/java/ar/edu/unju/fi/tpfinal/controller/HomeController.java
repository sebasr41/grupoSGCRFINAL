package ar.edu.unju.fi.tpfinal.controller;
/**
 * author CGRS
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
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
