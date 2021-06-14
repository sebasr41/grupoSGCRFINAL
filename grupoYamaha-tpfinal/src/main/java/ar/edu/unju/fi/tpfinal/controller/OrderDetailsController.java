package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.OrderDetails;
import ar.edu.unju.fi.tpfinal.model.Orders;
import ar.edu.unju.fi.tpfinal.model.Products;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailsService;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;
import ar.edu.unju.fi.tpfinal.service.IProductsService;
@Controller
public class OrderDetailsController {
	@Autowired
	private OrderDetails orderdetails;
	@Autowired
	private Orders order;
	
	@Autowired
	private IOrderDetailsService orderdetailsService;
	
	@Autowired
	private IOrdersService orderService;

	@Autowired
	private IProductsService productsService;
	
	@GetMapping("/orderdetails-{id}")
	public ModelAndView getOrderDetailsPage(@PathVariable (value = "id") Long id) {
	
		
		ModelAndView modelView = new ModelAndView("orderdetaiils");
		Optional<Products> products = productsService.obtenerProductsPorId(id);
		
		return modelView;
}
	@PostMapping("/orderdetails-guardar")
	public ModelAndView OrderDetailsPage(@Valid @ModelAttribute("orderdetails") OrderDetails orderdetails,@ModelAttribute("order") Orders order, BindingResult resultadoValidacion){
		
		//////// validation
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()) {
		modelView= new ModelAndView("orderdetails"); 
		return modelView;
		}
		
		else {
			 modelView = new ModelAndView("orderdetails-list");
			 orderdetailsService.guardarOrderDetails(orderdetails);
			 orderService.guardarOrders(order);
		modelView.addObject("orderdetails", orderdetailsService.obtenerOrderDetails());
		modelView.addObject("order", orderService.obtenerOrders());
		return modelView;
		}
	}
}