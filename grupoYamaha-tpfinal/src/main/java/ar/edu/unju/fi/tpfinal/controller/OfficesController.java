package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class OfficesController {
	@Autowired
	private Offices offices;
	

	@Autowired
	private IOfficesService officesService;

	@GetMapping("/offices")
	public String getOfficesPage(Model model) {
		model.addAttribute(offices);
		return "nueva-oficina";
	}
	@PostMapping("/offices-guardar")
	public ModelAndView guardarOfficesPage(@Valid @ModelAttribute("offices") Offices offices, BindingResult resultadoValidacion){
		
		//
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()) {
		modelView= new ModelAndView("nueva-oficina"); 
		return modelView;
		}
		
		else {
			 modelView = new ModelAndView("lista-oficina");
		officesService.guardarOffices(offices);
		modelView.addObject("productos", officesService.obtenerOffices());
		
		return modelView;
		}
}
	

	

}
