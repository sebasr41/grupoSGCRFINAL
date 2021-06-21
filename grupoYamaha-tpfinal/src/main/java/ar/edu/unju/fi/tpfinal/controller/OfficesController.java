package ar.edu.unju.fi.tpfinal.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.tpfinal.model.Offices;
import ar.edu.unju.fi.tpfinal.model.ProductLines;
import ar.edu.unju.fi.tpfinal.model.Products;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.IOfficesService;



@Controller
public class OfficesController {
	@Autowired
	private Offices offices;
	@Autowired
	private IOfficesService officesService;
	
	@Autowired
	private IEmployeesService employeesService;

	@GetMapping("/offices")
	public String getOfficesPage(Model model) {
		model.addAttribute(offices);
		
		return "nueva-oficina";
	}
	@PostMapping("/offices-guardar")
	public ModelAndView guardarOfficesPage(@Valid @ModelAttribute("offices") Offices offices, BindingResult resultadoValidacion){
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()) {
		modelView= new ModelAndView("nueva-oficina"); 
		return modelView;
		}
		else {
			 modelView = new ModelAndView("lista-oficina");
		officesService.guardarOffices(offices);
		modelView.addObject("offices", officesService.obtenerOffices());
		return modelView;
		
		}
		
		}
	@GetMapping("/offices-list")
	public ModelAndView getOfficesPage() {
		ModelAndView model = new ModelAndView("lista-oficina");
		model.addObject("offices", officesService.obtenerOffices());
	
		return model;

}
	
	@GetMapping("/office-eliminar-{id}")
	public ModelAndView getOfficezEliminarPage(@PathVariable(value = "id") long id, RedirectAttributes attribute) {
		ModelAndView modelView = new ModelAndView("redirect:/offices-list");
		
			
		
			if (employeesService.obtenerEmployeesPorOfficeCode(id).isEmpty()) {
				officesService.eliminarOffices(id);
				attribute.addFlashAttribute("warning", "Oficina eliminado con exito");
					
			}else {
				attribute.addFlashAttribute("warning", "No se puede eliminar, la Oficina ya tiene empleados ");
			}
		
		return modelView;
	}

	@GetMapping("/office-editar-{id}")
	public ModelAndView getOfficeEditPage(@PathVariable(value = "id") long id) {

		ModelAndView modelView = new ModelAndView("nueva-oficina");

		Optional<Offices> offices = officesService.getOfficesPorId(id);

		modelView.addObject("offices",offices);
		

		return modelView;
	}
	
}
