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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.Employees;
import ar.edu.unju.fi.tpfinal.model.Offices;
import ar.edu.unju.fi.tpfinal.model.ProductLines;
import ar.edu.unju.fi.tpfinal.model.Products;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.IOfficesService;

@Controller

public class EmployeesController {
	
	@Autowired 
	private Employees employees;
	@Autowired
	private Offices offices;
	@Autowired
	private IEmployeesService employeesService;
	@Autowired
	private IOfficesService officesService;
	
	@GetMapping("/empleados")
	public String getEmployeesPage(Model model) {
		model.addAttribute(employees);
		model.addAttribute(offices);
		model.addAttribute("offices" , officesService.obtenerOffices());
		
		return "nuevo-empleado";
	}
	
	
	@PostMapping("/empleado-guardar")
	public ModelAndView guardarOfficesPage(@Valid @ModelAttribute("employees") Employees employees, BindingResult resultadoValidacion){
		
		//
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()) {
			modelView= new ModelAndView("nuevo-empleado"); 
				List<Offices> offices = officesService.obtenerOffices();
				modelView.addObject("empleados", employees);
				modelView.addObject("offices", offices);
				return modelView;
			
				}
				
				else {
				ModelAndView model = new ModelAndView("redirect:/products-list");
				
				Optional<Offices> offices = officesService.getOfficesPorId(employees.getOffices().getOfficeCode());
				
				offices.ifPresent(employees::setOffices);
				
			
				employeesService.guardarEmployees(employees);
				
				model.addObject("employeers", employeesService.obtenerEmployees());
				model.addObject("employees",employees);
				model.addObject("offices", officesService.obtenerOffices());

				
				return model;
	
				
				}
		}
}