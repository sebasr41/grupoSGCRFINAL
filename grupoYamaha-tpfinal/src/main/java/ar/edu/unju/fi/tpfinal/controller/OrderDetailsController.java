package ar.edu.unju.fi.tpfinal.controller;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

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

import ar.edu.unju.fi.tpfinal.model.Customers;
import ar.edu.unju.fi.tpfinal.model.OrderDetails;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;
import ar.edu.unju.fi.tpfinal.model.Orders;
import ar.edu.unju.fi.tpfinal.model.Payments;
import ar.edu.unju.fi.tpfinal.model.PaymentsId;
import ar.edu.unju.fi.tpfinal.model.Products;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailsService;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;
import ar.edu.unju.fi.tpfinal.service.IPaymenService;
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
	private ICustomersService customerService;
	
	@Autowired
	private IPaymenService paymentService;
	
	
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
		
		modelView.addObject("orders", orderService.obtenerOrders());
		modelView.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());

		return modelView;
}
	@GetMapping("/order-list")
	public ModelAndView getComprasPage() {
		ModelAndView model = new ModelAndView("lista-ordenes");
		
		model.addObject("orders", orderService.obtenerOrders());
		model.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());
		

		
		return model;
	
	}
	
	public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
	
	@PostMapping("/order-form-{id}")
	public ModelAndView OrderDetailsPage(@PathVariable (value = "id") String id,@Valid @ModelAttribute("orderdetails") OrderDetails orderdetails, BindingResult resultadoValidacion){
		//////// validation
		ModelAndView modelView;
		System.out.println("orderDetails llllllllllllllllllllllll:"+orderdetails);

			
			
			 LocalDate hoy = LocalDate.now();
			 orders.setOrderDate(hoy);
			 Random r = new Random(); 
			 
			 Optional<Customers> custom = customerService.getCustomersPorId(orderdetails.getId().getOrderNumber().getCustomers().getCustomerNumber());
			 PaymentsId payid = new PaymentsId(custom.get(),generateString());
			 
			 
			 
			 custom.ifPresent(orders::setCustomers);
			 orders.setShippedDate(hoy.plusDays(r.nextInt(10)));
			 orders.setRequiredDate(orders.getShippedDate().plusDays(10));
			 orders.setStatus("Procesando");
			 
			Optional<Products> products = productsService.obtenerProductsPorId(id);
			products.ifPresent(oID::setProductCode);
			oID.setOrderNumber(orderService.guardarOrders(orders));
			orderdetails.setId(oID);
			modelView = new ModelAndView("redirect:/order-list");
			
			Products precio = products.get();
			orderdetails.setPriceEach(precio.getBuyPrice());
			Payments pay = new Payments(payid,hoy.plusDays(r.nextInt(7)), orderdetails.getQuantityOrdered()* orderdetails.getPriceEach());
			
			paymentService.guardarPayment(pay);
			 
			 
			orderdetailsService.guardarOrderDetails(orderdetails);
			
				
		return modelView;
		}
	//}
}
