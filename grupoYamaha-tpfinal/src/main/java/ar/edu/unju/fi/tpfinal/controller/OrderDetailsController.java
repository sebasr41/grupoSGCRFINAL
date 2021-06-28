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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailsService;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;
import ar.edu.unju.fi.tpfinal.service.IPaymenService;
import ar.edu.unju.fi.tpfinal.service.IProductsService;
import ar.edu.unju.fi.tpfinal.service.UsuarioService;
/**
 * Esta anotacion @Controller indica que tiene pequeaas tareas derivada de la clase controller.
 * Aqui se responde a la interacción (eventos) que hace el usuario en la interfaz 
 * y realiza las peticiones necesarias (a la interfaces, clases,etc) para obtener lo que pide la vista.
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
	
	@Autowired
	private UsuarioService usuarioService;

	
	/**
	 * Metodo GetMapping. Para cancelar la orden de compra.
	 * @param id
	 * @param model
	 * @return redirect de order-list con el status "cancelado".
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
	
	
	/**
	 * Metodo GetMapping. Para obtener una lista de ordenes.
	 * @param model
	 * @return lista-ordenes.
	 */
	@GetMapping("/order-list")
	public ModelAndView getOrderPage() {
		ModelAndView model = new ModelAndView("lista-ordenes");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		Usuario usuario = usuarioService.getByNombreUsuario(userDetails.getUsername()).get();
		
		if(usuario.getCustomers()!= null) {
			model.addObject("ordersF",orders);
			//model.addObject("orders", orderService.obtenerOrdersPorcustomerNumber(usuario.getCustomers().getCustomerNumber()));
			model.addObject("orderDetails", orderdetailsService.obtenerOrderDetailsporCustomerNumber(usuario.getCustomers().getCustomerNumber()));
			return model;
		}else {
			
			model.addObject("ordersF",orders);
			model.addObject("orders", orderService.obtenerOrders());
			model.addObject("orderDetails", orderdetailsService.obtenerOrderDetails());
			return model;
		}		
		
	}
	
	/**
	 * Metodo PostMapping. Para agregar comentario a la order.
	 * @param id
	 * @param orders
	 * @return redirect de order-list con el comentario.
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


	 

   /**
    * Metodo publico para generar un string aleatorio.
    * @return String aleatorio.
    */
	public static String generateString() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
	
	/**
	 * Metodo PostMapping. Para guardar los datos obtenidos del form ProductsList.
	 * @param id
	 * @param orderdetails
	 * @param resultadoValidacion
	 * @param attribute
	 * @return  Si hay errores un redirect a product list, sino guardar los datos en la order-list.
	 */
	@PostMapping("/order-form-{id}")
	public ModelAndView OrderDetailsPage(@PathVariable(value = "id") String id, @Valid @ModelAttribute("orderdetails") OrderDetail orderdetails, BindingResult resultadoValidacion, RedirectAttributes attribute) {
		ModelAndView modelView;
		
	     if (resultadoValidacion.getErrorCount() >1) {
			ModelAndView model = new ModelAndView("redirect:/products-list");
			
			attribute.addFlashAttribute("warning", "No lleno los datos");
			return model;

		}
        /*
         * Obtiene los datos del usuario logueado.
         */
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Usuario usuario = usuarioService.getByNombreUsuario(userDetails.getUsername()).get();
		// Obtenemos productos mediante el id de la url.
		Optional<Product> products = productsService.obtenerProductsPorId(id);
		
		Product proControl = products.get();
		//CONTROL DE ADMIN 
		if (usuario.getCustomers() != null) {
			//Control limite de credito.
		if ((proControl.getBuyPrice()*orderdetails.getQuantityOrdered()) > usuario.getCustomers().getCreditLimit()) {
			ModelAndView model = new ModelAndView("redirect:/products-list");
			attribute.addFlashAttribute("warning", "No tenes limite suficiente");
			return model;
		}}
		// Obtenemos el dia actual y lo seteamos en Order.
		LocalDate hoy = LocalDate.now();
		orders.setOrderDate(hoy);
		Random aelotorio = new Random();
		/*
		* Payments : Se crea un payment id.
		*/
		PaymentId payid =new PaymentId() ;
		//Control de seteo de costomers segun el rol.
		if (usuario.getCustomers() == null) {
			//admin
			Optional<Customer> custom = customerService.getCustomersPorId(orderdetails.getId().getOrderNumber().getCustomers().getCustomerNumber());
			// auto-generamos un id string para payment id para que no tire que es nulo.
			 payid = new PaymentId(custom.get(), generateString());
            // Seteamos customers en orders.
			custom.ifPresent(orders::setCustomers);
		}else {
			
			//Usuario
			orders.setCustomers(usuario.getCustomers());
			//Creamos un payment id con el customer de usuario
			payid = new PaymentId(usuario.getCustomers(), generateString());
			
		}
		//Seteo de datos de orders.	
		orders.setShippedDate(hoy.plusDays(aelotorio.nextInt(10)));
		orders.setRequiredDate(orders.getShippedDate().plusDays(10));
		orders.setStatus("Procesando");

		//Seteamos un Product en oID.
		products.ifPresent(oID::setProductCode);
		// Seteamos orderNumber(null) para evitar que los datos se sobre escriban.
		orders.setOrderNumber(null);
		//Seteamos orders en oID, luego seteamos oID en orderdetails.
		oID.setOrderNumber(orderService.guardarOrders(orders));
		orderdetails.setId(oID);
		modelView = new ModelAndView("redirect:/order-list");
        //Codigo para actualizar el stock y setear el precio en orderdetails.
		Product precio = products.get();
		precio.setQuantityInStock(precio.getQuantityInStock()-orderdetails.getQuantityOrdered());
		productsService.guardarProducts(precio);
		orderdetails.setPriceEach(precio.getBuyPrice());
		//Seteamos payment y guardamos los datos.
		Payment pay = new Payment(payid, hoy.plusDays(aelotorio.nextInt(7)),
				orderdetails.getQuantityOrdered() * orderdetails.getPriceEach());

		paymentService.guardarPayment(pay);

		orderdetailsService.guardarOrderDetails(orderdetails);

		return modelView;

	}
	
	/**
	 *  Metodo GetMapping. Obtenemos una lista de pagos.
	 * 
	 * @return lista-pagos.
	 */
	@GetMapping("/payments-list")
	public ModelAndView getPaymentsPage() {
		
		ModelAndView model = new ModelAndView("lista-pagos");

		model.addObject("paymentList", paymentService.obtenerPayments());

		return model;

	}
}
