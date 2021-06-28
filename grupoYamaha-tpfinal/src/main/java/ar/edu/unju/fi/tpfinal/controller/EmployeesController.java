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
 * Esta anotacion @Controller indica que tiene pequeaas tareas derivada de la clase controller.
 * Aqui se responde a la interacción (eventos) que hace el usuario en la interfaz 
 * y realiza las peticiones necesarias (a la interfaces, clases,etc) para obtener lo que pide la vista.
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
	 * Metodo GetMapping.
	 * @param model
	 * @return form empleado
	 */
	@GetMapping("/empleados")
	public String getEmployeesPage(Model model) {
		employeesService.generarAdmins();
		model.addAttribute("employees",employees);
		model.addAttribute(offices);
		model.addAttribute("employlist", employeesService.obtenerEmployees());

		model.addAttribute("offices", officesService.obtenerOffices());

		return "nuevo-empleado";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo PostMapping. Guarda datos obtenidos
	 * @param employees
	 * @param resultadoValidacion
	 * @return Si hay errores retorna el form, sino la lista de empleados.
	 */
	@PostMapping("/empleado-guardar")
	public ModelAndView guardarOfficesPage(@Valid @ModelAttribute("employees") Employee employees,
			BindingResult resultadoValidacion) {
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("nuevo-empleado");
			List<Office> offices = officesService.obtenerOffices();
			modelView.addObject("employlist", employeesService.obtenerEmployees());
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
	 * Metodo GetMapping. 
	 * @return lista de empleados.
	 */
	@GetMapping("/employees-list")
	public ModelAndView getCustomerPage() {
		ModelAndView model = new ModelAndView("lista-empleados");
		model.addObject("employeeslist", employeesService.obtenerEmployees());
		return model;

	
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo GetMapping.
	 * @param id
	 * @return form de empleado.
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
	 * Metodo GetMapping.
	 * @param id
	 * @param attribute
	 * @return Si el empleado no tiene empleados a cargo se elimina, sino retorna la misma pagina.
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