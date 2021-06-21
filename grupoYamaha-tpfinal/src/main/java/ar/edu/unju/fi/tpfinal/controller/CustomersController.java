package ar.edu.unju.fi.tpfinal.controller;

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

import ar.edu.unju.fi.tpfinal.model.Customers;
import ar.edu.unju.fi.tpfinal.model.Employees;

import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;

@Controller
public class CustomersController {

	@Autowired
	private ICustomersService customersService;

	@Autowired
	private IEmployeesService employeesService;

	@Autowired
	private Customers customers;

	@Autowired
	private IEmployeesService employservice;

	@GetMapping("/crearusuario")
	public String getCustomersPage(Model model) {
		model.addAttribute("customers", customers);
		model.addAttribute("employs", employservice.obtenerEmployees());
		return "nuevo-usuario";
	}

	@PostMapping("/usuario-guardar")
	public ModelAndView getGuardarCustomersPage(@Valid @ModelAttribute("customers") Customers customers,
			BindingResult resultadoValidacion) {
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("nuevo-usuario");

			modelView.addObject("customers", customers);
			modelView.addObject("employs", employservice.obtenerEmployees());
			return modelView;

		}

		else {
			ModelAndView model = new ModelAndView("customer-list");

			Optional<Employees> employees = employeesService
					.getEmployeesPorId(customers.getEmployees().getEmployeeNumber());
			employees.ifPresent(customers::setEmployees);

			customersService.guardarCustomers(customers);

			return model;
		}

	}

	@GetMapping("/customer-list")
	public ModelAndView getCustomerPage() {
		ModelAndView model = new ModelAndView("lista-usuario");
		model.addObject("customers", customersService.obtenerCustomers());

		return model;

	}

}