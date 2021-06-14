package ar.edu.unju.fi.tpfinal;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
	   @GetMapping("/home")
	    public String getIndexPage(){
	        return "index";
	    }
}
