package ar.edu.unju.fi.tpfinal.controller;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.OrderDetails;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;
import ar.edu.unju.fi.tpfinal.model.Orders;
import ar.edu.unju.fi.tpfinal.model.Products;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailsService;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;
import ar.edu.unju.fi.tpfinal.service.IProductsService;
@Controller
public class OrderDetailsController {


	@Autowired
	private IOrderDetailsService orderdetailsService;
	
	@Autowired
	private IOrdersService orderService;
	
	@Autowired
	private OrderDetailsId oID;
	
	
	
	@Autowired
	private IProductsService productsService;
	@Autowired
	private Orders orders;
	@Autowired
	private OrderDetails orderdetails;
	@Autowired
	private Products products;

	@GetMapping("/orden-cancelar-{id}")
	public ModelAndView getOrderCancellPage(@PathVariable (value = "id") Long id, Model model) {
	
		ModelAndView modelView = new ModelAndView("redirect:/order-list");
		
		Optional<Orders> order =orderService.obtenerOrdersPorId(id);
		System.out.println(order);
		orders = order.get();
		orders.setStatus("Cancelado");
		orderService.guardarOrders(orders);
		//Orders orderGuardar = orderDaux.getOrders();
		//orderGuardar.setStatus("Cancelado");
		
		//orderService.guardarOrders(orderGuardar);
		
		modelView.addObject("orders", orderService.obtenerOrders());
		modelView.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());

		//modelView.addObject("products", products);
		return modelView;
}
	@GetMapping("/order-list")
	public ModelAndView getComprasPage() {
		ModelAndView model = new ModelAndView("lista-ordenes");
		
		model.addObject("orders", orderService.obtenerOrders());
		model.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());
		

		
		return model;
	
	}

	@PostMapping("/order-form-{id}")
	public ModelAndView OrderDetailsPage(@PathVariable (value = "id") String id,@Valid @ModelAttribute("orderdetails") OrderDetails orderdetails, BindingResult resultadoValidacion){
		//////// validation
		ModelAndView modelView;
		System.out.println("orderDetails llllllllllllllllllllllll:"+orderdetails);

		//if(resultadoValidacion.hasErrors()) {
		//modelView= new ModelAndView("orderdetails"); 
		//return modelView;
		//}
		
		//else {
			
			 LocalDate hoy = LocalDate.now();
			 orders.setOrderDate(hoy);
			 Random r = new Random(); 
			 
			 
			 orders.setShippedDate(hoy.plusDays(r.nextInt(10)));
			 orders.setRequiredDate(orders.getShippedDate().plusDays(10));
			 orders.setStatus("Procesando");
			 
			Optional<Products> products = productsService.obtenerProductsPorId(id);
			products.ifPresent(oID::setProductCode);
			oID.setOrderNumber(orderService.guardarOrders(orders));
			orderdetails.setId(oID);
			//orders = orderdetails.getOrders();
			modelView = new ModelAndView("redirect:/order-list");
			//orders.setOrderDetails(orderdetails);
			// orderdetails.setOrders(null);
			 //products.ifPresent(orderdetails::setProducts);
			Products precio = products.get();
			orderdetails.setPriceEach(precio.getBuyPrice());
			 
			 
			orderdetailsService.guardarOrderDetails(orderdetails);
			 //orders.setOrderNumber(id);
			
				//modelView.addObject("orders", orderService.obtenerOrders());
				//modelView.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());
				
		return modelView;
		}
	//}
}
