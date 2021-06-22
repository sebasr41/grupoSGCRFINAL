package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getLoginPage() {
		
		return "login";
	}
	@GetMapping("/logout")
	public String getLogoutpage() {
		
		return "logout";
	}
	
}
