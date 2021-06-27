package ar.edu.unju.fi.tpfinal.controller;
/**
 * author CGRS
 */
import java.util.List;
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
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailsService;
import ar.edu.unju.fi.tpfinal.service.IProductLinesService;
import ar.edu.unju.fi.tpfinal.service.IProductsService;
/**
 * 
 * @author 2021
 *
 */
@Controller
public class ProductsController {
	@Autowired
	private Product products;

	@Autowired
	private Customer custom;
	
	@Autowired
	private IOrderDetailsService orderdetailsService;

	@Autowired
	private IProductLinesService productslinesService;

	@Autowired
	private ICustomersService customerService;

	@Autowired
	private IProductsService productsService;

	@Autowired
	private OrderDetail orderdetails;
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/products")
	public String getProductsPage(Model model) {
		model.addAttribute("products", products);
		model.addAttribute("productslines", productslinesService.obtenerProductLines());
		if(productslinesService.obtenerProductLines().isEmpty()) {
			model.addAttribute("bandera", false);
		}else {
			model.addAttribute("bandera", true);

		}


		return "nuevo-producto";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param products
	 * @param resultadoValidacion
	 * @param attribute
	 * @return
	 */
	@PostMapping("/products-save")
	public ModelAndView getGuardarProductsPage(@Valid @ModelAttribute("products") Product products,
			BindingResult resultadoValidacion, RedirectAttributes attribute) {
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {
			modelView = new ModelAndView("nuevo-producto");
			List<ProductLine> productslines = productslinesService.obtenerProductLines();
			modelView.addObject("bandera", true);
			modelView.addObject("products", products);
			modelView.addObject("productslines", productslines);
			return modelView;

		}

		else {
			ModelAndView model = new ModelAndView("redirect:/products-list");

			Optional<ProductLine> productslines = productslinesService
					.getProductolinesPorId(products.getProductLines().getProductLinesName());

			productslines.ifPresent(products::setProductLines);

			productsService.guardarProducts(products);

			model.addObject("products", productsService.obtenerProducts());
			model.addObject("product", products);
			model.addObject("productslines", productslinesService.obtenerProductLines());
			attribute.addFlashAttribute("success", "Vehículo guardado con exito");
			
			return model;
		}

	}
	/**
	 * 
	 * @return
	 */
	@GetMapping("/products-list")
	public ModelAndView getProductsPage() {
		ModelAndView model = new ModelAndView("lista-productos");
		model.addObject("product", products);
		model.addObject("products", productsService.obtenerProducts());
		model.addObject("productslines", productslinesService.obtenerProductLines());
		// New
		model.addObject("orderdetails", orderdetails);
		model.addObject("customers", customerService.obtenerCustomers());
		model.addObject("custom", custom);
		if (customerService.obtenerCustomers().isEmpty()) {
			model.addObject("bandera", false);
		}else {
			model.addObject("bandera", true);
		}

		return model;

	}
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param id
	 * @param attribute
	 * @return
	 */
	@GetMapping("/products-eliminar-{id}")
	public ModelAndView getProductsEliminarPage(@PathVariable(value = "id") String id, RedirectAttributes attribute) {
		ModelAndView modelView = new ModelAndView("redirect:/products-list");
		
		if (orderdetailsService.obtenerOrderDetailsporProductCode(id).isEmpty()) {
			productsService.eliminarProducts(id);
			attribute.addFlashAttribute("warning", "Vehículo eliminado con exito");
				
		}else {
			attribute.addFlashAttribute("warning", "No se puede eliminar, el vehículo ya tiene ordenes ");
		}
		
		
		
		
		return modelView;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/products-editar-{id}")
	public ModelAndView getProductsEditPage(@PathVariable(value = "id") String id) {

		ModelAndView modelView = new ModelAndView("nuevo-producto");

		Optional<Product> products = productsService.obtenerProductsPorId(id);

		List<ProductLine> productslines = productslinesService.obtenerProductLines();
		modelView.addObject("products", products);
		modelView.addObject("productslines", productslines);
		modelView.addObject("bandera", true);

		return modelView;
	}
	
	/**
	 * 
	 * @param model
	 * @param products
	 * @return
	 */
	@PostMapping("/products-busqueda")
	public String buscarProducts(Model model, @ModelAttribute(name = "product") Product products) {

		model.addAttribute("product", products);
		model.addAttribute("products", productsService.buscarProducts(products.getProductName(),
				products.getProductLines().getProductLinesName(), products.getBuyPrice()));
		model.addAttribute("productslines", productslinesService.obtenerProductLines());
		model.addAttribute("orderdetails", orderdetails);
		return "lista-productos";
	}
}