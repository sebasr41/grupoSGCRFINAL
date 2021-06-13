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
@Controller
public class OrderDetailsController {
	@Autowired
	private OrderDetails orderdetails;
	@Autowired
	private Order order;
	
	@Qualifier("OrderDetailsServiceMysql")
	@Autowired
	private IOrderDetails orderdetailsService;
	
	@Qualifier("OrderMysql")
	@Autowired
	private IOrderService orderService;
	
	@GetMapping("/orderdetails-{id}")
	public ModelAndView getOrderDetailsPage(@PathVariable (value = "id") Long id) {
	
		
		ModelAndView modelView = new ModelAndView("orderdetaiils");
		Optional<Products> products = productsService.getProductsPorId(id);
		
		return modelView;
}
	@PostMapping("/orderdetails-guardar")
	public ModelAndView OrderDetailsPage(@Valid @ModelAttribute("orderdetails") OrderDetails orderdetails,@ModelAttribute("order") Order order, BindingResult resultadoValidacion){
		
		//////// validation
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()) {
		modelView= new ModelAndView("orderdetails"); 
		return modelView;
		}
		
		else {
			 modelView = new ModelAndView("orderdetails-list");
			 orderdetailsService.guardarOrderDetails(orderdetails);
			 orderService.guardarOrder(order);
		modelView.addObject("orderdetails", orderdetailsService.obtenerOrderDetails());
		modelView.addObject("order", orderService.obtenerOrder());
		return modelView;
		}
	}
}
