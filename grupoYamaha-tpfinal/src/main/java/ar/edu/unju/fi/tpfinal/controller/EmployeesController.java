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

import ar.edu.unju.fi.tpfinal.model.Customers;
import ar.edu.unju.fi.tpfinal.model.Employees;
import ar.edu.unju.fi.tpfinal.model.Offices;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
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
	
	@Autowired
	private ICustomersService customersService;

	@GetMapping("/empleados")
	public String getEmployeesPage(Model model) {
		employeesService.generarAdmins();
		model.addAttribute(employees);
		model.addAttribute(offices);
		model.addAttribute("employlist", employeesService.obtenerEmployees());

		model.addAttribute("offices", officesService.obtenerOffices());

		return "nuevo-empleado";
	}

	@PostMapping("/empleado-guardar")
	public ModelAndView guardarOfficesPage(@Valid @ModelAttribute("employees") Employees employees,
			BindingResult resultadoValidacion) {

		//validaciones  si hay error retorna el form
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("nuevo-empleado");
			List<Offices> offices = officesService.obtenerOffices();
			modelView.addObject("empleados", employees);
			modelView.addObject("offices", offices);

			return modelView;

		}

		else {

			ModelAndView model = new ModelAndView("redirect:/employees-list");
			Optional<Offices> offices = officesService.getOfficesPorId(employees.getOffices().getOfficeCode());
		

			offices.ifPresent(employees::setOffices);
			Optional<Employees> boss = employeesService.getEmployeesPorId(employees.getEmployees().getEmployeeNumber());
			boss.ifPresent(employees::setEmployees);

			employeesService.guardarEmployees(employees);

			model.addObject("employees", employeesService.obtenerEmployees());

			return model;

		}
	}
	@GetMapping("/employees-list")
	public ModelAndView getCustomerPage() {
		ModelAndView model = new ModelAndView("lista-empleados");
		model.addObject("employeeslist", employeesService.obtenerEmployees());
		return model;

	
	}
	
	@GetMapping("/employee-editar-{id}")
	public ModelAndView getCustomerEditPage(@PathVariable(value= "id")Long id) {
		ModelAndView modelView = new ModelAndView("nuevo-empleado");
		Optional<Employees> employees = employeesService.getEmployeesPorId(id);
		modelView.addObject("employees", employees);
		modelView.addObject(offices);
		modelView.addObject("employlist", employeesService.obtenerEmployees());

		modelView.addObject("offices", officesService.obtenerOffices());

		return modelView;
	}
	
	@GetMapping("/employee-eliminar-{id}")
	public ModelAndView getCustomersEliminarPage(@PathVariable(value = "id") Long id, RedirectAttributes attribute) {
		ModelAndView modelView = new ModelAndView("redirect:/employees-list");
		if (customersService.obtenerCustomersPorEmployeeNumber(id).isEmpty()) {
			
			if (employeesService.obtenerEmployeesPorEmployeesNumber(id).isEmpty()) {
				employeesService.eliminarEmployees(id);
				attribute.addFlashAttribute("warning", "Empleado eliminado con exito");
			}else {
				attribute.addFlashAttribute("warning", "No se puede eliminar, el empleado tiene Empleado/s a cargo");
			}
			
			
				
		}else {
			attribute.addFlashAttribute("warning", "No se puede eliminar, el empleado ya realizó una venta");
		}
	
	return modelView;
		
	}
}