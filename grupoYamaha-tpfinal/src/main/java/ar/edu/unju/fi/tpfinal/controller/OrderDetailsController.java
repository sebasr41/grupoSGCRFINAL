package ar.edu.unju.fi.tpfinal.controller;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

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

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/orden-cancelar-{id}")
	public ModelAndView getOrderCancellPage(@PathVariable(value = "id") Long id, Model model) {

		ModelAndView modelView = new ModelAndView("redirect:/order-list");

		Optional<Orders> order = orderService.obtenerOrdersPorId(id);
		System.out.println(order);
		orders = order.get();
		orders.setStatus("Cancelado");
		orderService.guardarOrders(orders);

		modelView.addObject("orders", orderService.obtenerOrders());
		modelView.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());

		return modelView;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/order-list")
	public ModelAndView getOrderPage() {
		ModelAndView model = new ModelAndView("lista-ordenes");
		model.addObject("ordersF",orders);
		model.addObject("orders", orderService.obtenerOrders());
		model.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());

		return model;

	}
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/order-add-comments-{id}")
	public ModelAndView getOrderAddCommentPage(@PathVariable(value="id")Long id, @Valid @ModelAttribute("ordersF") Orders orders) {
		ModelAndView modelView = new ModelAndView("redirect:/order-list");
		Optional<Orders> order = orderService.obtenerOrdersPorId(id);
		Orders aux = order.get();
		aux.setComments(orders.getComments());
		
		orderService.guardarOrders(aux);
        modelView.addObject("ordersF",orders);
		modelView.addObject("orders", orderService.obtenerOrders());
		modelView.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());
		
		return modelView;
	}


	 


	public static String generateString() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/order-form-{id}")
	public ModelAndView OrderDetailsPage(@PathVariable(value = "id") String id,
			@Valid @ModelAttribute("orderdetails") OrderDetails orderdetails, BindingResult resultadoValidacion, RedirectAttributes attribute) {
		ModelAndView modelView;
		System.out.println("aaaaaaaaaaaaa"+ resultadoValidacion.getErrorCount());
		
		if (resultadoValidacion.getErrorCount() >1) {
			ModelAndView model = new ModelAndView("redirect:/products-list");
			System.out.println("sssssssssssssssssssss"+ orderdetails);
			
			attribute.addFlashAttribute("warning", "No lleno los datos");
			return model;

		}

		else {
			
			
		}
		
		
		
		LocalDate hoy = LocalDate.now();
		orders.setOrderDate(hoy);
		// dia random hasta el dia especificado en este caso se uso 10 dias despues//
		Random aelotorio = new Random();

		Optional<Customers> custom = customerService
				.getCustomersPorId(orderdetails.getId().getOrderNumber().getCustomers().getCustomerNumber());
		// auto-generamos un id string para que no tire que es nulo //
		PaymentsId payid = new PaymentsId(custom.get(), generateString());

		custom.ifPresent(orders::setCustomers);
		orders.setShippedDate(hoy.plusDays(aelotorio.nextInt(10)));
		orders.setRequiredDate(orders.getShippedDate().plusDays(10));
		orders.setStatus("Procesando");

		Optional<Products> products = productsService.obtenerProductsPorId(id);
		products.ifPresent(oID::setProductCode);
		orders.setOrderNumber(null);
		oID.setOrderNumber(orderService.guardarOrders(orders));
		orderdetails.setId(oID);
		modelView = new ModelAndView("redirect:/order-list");

		Products precio = products.get();
		orderdetails.setPriceEach(precio.getBuyPrice());
		Payments pay = new Payments(payid, hoy.plusDays(aelotorio.nextInt(7)),
				orderdetails.getQuantityOrdered() * orderdetails.getPriceEach());

		paymentService.guardarPayment(pay);

		orderdetailsService.guardarOrderDetails(orderdetails);

		return modelView;

	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/payments-list")
	public ModelAndView getPaymentsPage() {
		
		ModelAndView model = new ModelAndView("lista-pagos");

		model.addObject("paymentList", paymentService.obtenerPayments());

		return model;

	}
}
