package ar.edu.unju.fi.tpfinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.WebListenerRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.Customers;
import ar.edu.unju.fi.tpfinal.model.Employees;
import ar.edu.unju.fi.tpfinal.model.Offices;
import ar.edu.unju.fi.tpfinal.model.OrderDetails;
import ar.edu.unju.fi.tpfinal.model.Orders;
import ar.edu.unju.fi.tpfinal.model.ProductLines;
import ar.edu.unju.fi.tpfinal.model.Products;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;
import ar.edu.unju.fi.tpfinal.service.imp.CustomersServiceImp;

@Controller
public class CustomersController {
	

	@Autowired
	private Orders orders;	

	@Autowired
	private IOrdersService orderService;
	
	@Autowired
	private ICustomersService customersService;

	@Autowired
	private CustomersServiceImp customersServiceImp; 
	
	@Autowired
	private OrderDetails orderdetails;
	
	@Autowired
	private Employees employes;
	
	@Autowired
	private IEmployeesService employeesService;
	
	
@Autowired
private Customers customers;

@Autowired
private Employees employ;

@Autowired
private IEmployeesService employservice;

//NO es el verdadero controller lo subo rpovisoriamente solo para probar

@GetMapping("/crearusuario")
public String getCustomersPage(Model model){
	model.addAttribute("customers",customers);
	model.addAttribute("employs",  employservice.obtenerEmployees());
	return "nuevo-usuario";
}

@PostMapping("/usuario-guardar")
public ModelAndView getGuardarCustomersPage(@Valid @ModelAttribute("customers")Customers customers, BindingResult resultadoValidacion) {
	ModelAndView modelView;
	if(resultadoValidacion.hasErrors()) {
	modelView= new ModelAndView("nuevo-usuario"); 
	
	modelView.addObject("customers",customers);
	modelView.addObject("employs",  employservice.obtenerEmployees());
	modelView.addObject("bandera", true);
	return modelView;

	}
	
	else {
	ModelAndView model = new ModelAndView("redirect:/customer-list");
	
	Optional<Employees> employees = employeesService.getEmployeesPorId(customers.getEmployees().getEmployeeNumber());
	//Optional<Employees> employees = employeesService.getEmployeesPorId(customers.getEmployees().getgetProductLinesName());

	employees.ifPresent(customers::setEmployees);

		
	customersService.guardarCustomers(customers);
	
	
	
	return model;
	}		
	
}

@GetMapping("/customer-list")
public ModelAndView getComprasPage() {
	ModelAndView model = new ModelAndView("lista-usuario");
	
	
	model.addObject("customers", customersService.obtenerCustomers());

	
	return model;

}


}