package ar.edu.unju.fi.tpfinal.controller;
/**
 * author CGRS
 */
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

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailId;
import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.Payment;
import ar.edu.unju.fi.tpfinal.model.PaymentId;
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailsService;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;
import ar.edu.unju.fi.tpfinal.service.IPaymenService;
import ar.edu.unju.fi.tpfinal.service.IProductsService;
/**
 * 
 * 
 *
 */
@Controller
public class OrderDetailsController {

	@Autowired
	private IOrderDetailsService orderdetailsService;

	@Autowired
	private IOrdersService orderService;

	@Autowired
	private OrderDetailId oID;
	

	@Autowired
	private ICustomersService customerService;

	@Autowired
	private IPaymenService paymentService;

	@Autowired
	private IProductsService productsService;
	@Autowired
	private Order orders;

	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/orden-cancelar-{id}")
	public ModelAndView getOrderCancellPage(@PathVariable(value = "id") Long id, Model model) {

		ModelAndView modelView = new ModelAndView("redirect:/order-list");

		Optional<Order> order = orderService.obtenerOrdersPorId(id);
		System.out.println(order);
		orders = order.get();
		orders.setStatus("Cancelado");
		orderService.guardarOrders(orders);

		modelView.addObject("orders", orderService.obtenerOrders());
		modelView.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());

		return modelView;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @return
	 */
	@GetMapping("/order-list")
	public ModelAndView getOrderPage() {
		ModelAndView model = new ModelAndView("lista-ordenes");
		model.addObject("ordersF",orders);
		model.addObject("orders", orderService.obtenerOrders());
		model.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());

		return model;

	}
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param id
	 * @param orders
	 * @return
	 */
	@PostMapping("/order-add-comments-{id}")
	public ModelAndView getOrderAddCommentPage(@PathVariable(value="id")Long id, @Valid @ModelAttribute("ordersF") Order orders) {
		ModelAndView modelView = new ModelAndView("redirect:/order-list");
		Optional<Order> order = orderService.obtenerOrdersPorId(id);
		Order aux = order.get();
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
	
	/**
	 * 
	 * @param id
	 * @param orderdetails
	 * @param resultadoValidacion
	 * @param attribute
	 * @return
	 */
	@PostMapping("/order-form-{id}")
	public ModelAndView OrderDetailsPage(@PathVariable(value = "id") String id,
			@Valid @ModelAttribute("orderdetails") OrderDetail orderdetails, BindingResult resultadoValidacion, RedirectAttributes attribute) {
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

		Optional<Customer> custom = customerService
				.getCustomersPorId(orderdetails.getId().getOrderNumber().getCustomers().getCustomerNumber());
		// auto-generamos un id string para que no tire que es nulo //
		PaymentId payid = new PaymentId(custom.get(), generateString());

		custom.ifPresent(orders::setCustomers);
		orders.setShippedDate(hoy.plusDays(aelotorio.nextInt(10)));
		orders.setRequiredDate(orders.getShippedDate().plusDays(10));
		orders.setStatus("Procesando");

		Optional<Product> products = productsService.obtenerProductsPorId(id);
		products.ifPresent(oID::setProductCode);
		orders.setOrderNumber(null);
		oID.setOrderNumber(orderService.guardarOrders(orders));
		orderdetails.setId(oID);
		modelView = new ModelAndView("redirect:/order-list");

		Product precio = products.get();
		orderdetails.setPriceEach(precio.getBuyPrice());
		Payment pay = new Payment(payid, hoy.plusDays(aelotorio.nextInt(7)),
				orderdetails.getQuantityOrdered() * orderdetails.getPriceEach());

		paymentService.guardarPayment(pay);

		orderdetailsService.guardarOrderDetails(orderdetails);

		return modelView;

	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/payments-list")
	public ModelAndView getPaymentsPage() {
		
		ModelAndView model = new ModelAndView("lista-pagos");

		model.addObject("paymentList", paymentService.obtenerPayments());

		return model;

	}
}
