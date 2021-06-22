package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

	@GetMapping({"/","/login","/index","/login?error=true"})
	public String getPageLogin(Model model) {
		return "login";
	}
	
	@GetMapping("/logout")
	public String getPageLogout() {
		return "logout";
	}

}
