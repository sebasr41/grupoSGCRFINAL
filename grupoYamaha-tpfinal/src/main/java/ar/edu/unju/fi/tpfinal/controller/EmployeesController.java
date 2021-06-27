package ar.edu.unju.fi.tpfinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.IOfficesService;
/**
 * 
 * @author 2021
 *
 */
@Controller

public class EmployeesController {

	@Autowired
	private Employee employees;
	@Autowired
	private Office offices;
	@Autowired
	private IEmployeesService employeesService;
	@Autowired
	private IOfficesService officesService;
	
	@Autowired
	private ICustomersService customersService;
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/empleados")
	public String getEmployeesPage(Model model) {
		employeesService.generarAdmins();
		model.addAttribute(employees);
		model.addAttribute(offices);
		model.addAttribute("employlist", employeesService.obtenerEmployees());

		model.addAttribute("offices", officesService.obtenerOffices());

		return "nuevo-empleado";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param employees
	 * @param resultadoValidacion
	 * @return
	 */
	@PostMapping("/empleado-guardar")
	public ModelAndView guardarOfficesPage(@Valid @ModelAttribute("employees") Employee employees,
			BindingResult resultadoValidacion) {

		//validaciones  si hay error retorna el form
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("nuevo-empleado");
			List<Office> offices = officesService.obtenerOffices();
			modelView.addObject("empleados", employees);
			modelView.addObject("offices", offices);

			return modelView;

		}

		else {

			ModelAndView model = new ModelAndView("redirect:/employees-list");
			Optional<Office> offices = officesService.getOfficesPorId(employees.getOffices().getOfficeCode());
		

			offices.ifPresent(employees::setOffices);
			Optional<Employee> boss = employeesService.getEmployeesPorId(employees.getEmployees().getEmployeeNumber());
			boss.ifPresent(employees::setEmployees);

			employeesService.guardarEmployees(employees);

			model.addObject("employees", employeesService.obtenerEmployees());

			return model;

		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @return
	 */
	@GetMapping("/employees-list")
	public ModelAndView getCustomerPage() {
		ModelAndView model = new ModelAndView("lista-empleados");
		model.addObject("employeeslist", employeesService.obtenerEmployees());
		return model;

	
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/employee-editar-{id}")
	public ModelAndView getCustomerEditPage(@PathVariable(value= "id")Long id) {
		ModelAndView modelView = new ModelAndView("nuevo-empleado");
		Optional<Employee> employees = employeesService.getEmployeesPorId(id);
		modelView.addObject("employees", employees);
		modelView.addObject(offices);
		modelView.addObject("employlist", employeesService.obtenerEmployees());

		modelView.addObject("offices", officesService.obtenerOffices());

		return modelView;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param id
	 * @param attribute
	 * @return
	 */
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