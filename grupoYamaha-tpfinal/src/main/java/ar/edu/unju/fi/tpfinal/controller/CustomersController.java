package ar.edu.unju.fi.tpfinal.controller;
/**
 * author CGRS
 */
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

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Employee;

import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;
import ar.edu.unju.fi.tpfinal.service.UsuarioService;

/**
 * 
 * Este Controller es el que responde a la interacción (eventos) que hace
 * el usuario en la interfaz y realiza las peticiones al modelo para pasar estos a la vista.
 *
 */
@Controller
public class CustomersController {

	@Autowired
	private ICustomersService customersService;

	@Autowired
	private IEmployeesService employeesService;

	@Autowired
	private Customer customers;

	@Autowired
	private IEmployeesService employservice;
	@Autowired
	private IOrdersService ordersService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo GetMapping.
	 * @param model
	 * @return form de customers.
	 */
	@GetMapping("/crearusuario")
	public String getCustomersPage(Model model) {
		model.addAttribute("customers", customers);
		model.addAttribute("employs", employservice.obtenerEmployees());
		return "nuevo-usuario";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo PostMapping. Para guardar datos.
	 * @param customers
	 * @param resultadoValidacion
	 * @return Si hay errores retorna el form, sino la lista de customers.
	 */
	@PostMapping("/usuario-guardar")
	public ModelAndView getGuardarCustomersPage(@Valid @ModelAttribute("customers") Customer customers,
			BindingResult resultadoValidacion) {
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("nuevo-usuario");

			modelView.addObject("customers", customers);
			modelView.addObject("employs", employservice.obtenerEmployees());
			return modelView;

		}

		else {
			ModelAndView model = new ModelAndView("redirect:/customer-list");

			Optional<Employee> employees = employeesService
					.getEmployeesPorId(customers.getEmployees().getEmployeeNumber());
			employees.ifPresent(customers::setEmployees);

			customersService.guardarCustomers(customers);

			return model;
		}

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo GetMapping. 
	 * @return lista de customers.
	 */
	@GetMapping("/customer-list")
	public ModelAndView getCustomerPage() {
		ModelAndView model = new ModelAndView("lista-usuario");
		model.addObject("customers", customersService.obtenerCustomers());

		return model;

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo GetMapping.
	 * @param id
	 * @return form de customer.
	 */
	@GetMapping("/customer-editar-{id}")
	public ModelAndView getCustomerEditPage(@PathVariable(value= "id")Long id) {
		ModelAndView modelView = new ModelAndView("nuevo-usuario");
		Optional<Customer> customers = customersService.getCustomersPorId(id);
		modelView.addObject("customers", customers);
		
		return modelView;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo GetMapping.
	 * @param id
	 * @param attribute
	 * @return lista de customers.
	 */
	@GetMapping("/customer-eliminar-{id}")
	public ModelAndView getCustomersEliminarPage(@PathVariable(value = "id") Long id, RedirectAttributes attribute) {
		ModelAndView modelView = new ModelAndView("redirect:/customer-list");
		if (ordersService.obtenerOrdersPorcustomerNumber(id).isEmpty()) {
			if(usuarioService.getByCustomerCustomerName(id).isEmpty()) {
				customersService.eliminarCustomers(id);
				attribute.addFlashAttribute("warning", "Cliente eliminado con exito");
					
			}else {
				attribute.addFlashAttribute("warning", "No se puede eliminar, el cliente tiene un usuario asociado ");
			}
			
		}else {
			attribute.addFlashAttribute("warning", "No se puede eliminar, el cliente tiene una orden de compra cargada ");
		}
	
	return modelView;
		
	}

}