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
	 * 
	 * @return
	 */
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    /**
     * 
     * @return
     */
    @GetMapping("/forbidden")
    public String forbidden(){
        return "forbidden";
    }
}
