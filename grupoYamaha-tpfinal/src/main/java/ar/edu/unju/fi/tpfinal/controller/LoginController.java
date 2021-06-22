package ar.edu.unju.fi.tpfinal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	//pericion que reponde de la pagina login
	@GetMapping({"/","/login","/index","/login?error=true"})
	public String getPageLogin(Model model) {
		return "login";
	}
	//pericion que reponde de la pagina logout que ve la peticion y sale de la pagina	
	@GetMapping("/logout")
	public String getPageLogout() {
		return "logout";
	}

}
