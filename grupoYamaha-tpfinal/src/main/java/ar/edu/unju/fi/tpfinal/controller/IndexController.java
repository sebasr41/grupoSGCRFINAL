package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 
 * @author 2021
 *
 */
@Controller
public class IndexController {
	/**
	 * 
	 * @return
	 */
	@GetMapping("/home")
	public String getIndexPage() {
		return "index";
	}
}
