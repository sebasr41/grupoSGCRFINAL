package ar.edu.unju.fi.tpfinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import ar.edu.unju.fi.tpfinal.model.ProductLines;
import ar.edu.unju.fi.tpfinal.model.Products;
import ar.edu.unju.fi.tpfinal.service.IProductLinesService;
import ar.edu.unju.fi.tpfinal.service.IProductsService;

@Controller
public class ProductsController {
	@Autowired
	private Products products;
	

	

	@Autowired
	private IProductLinesService productslinesService;
	
	
	@Autowired
	private IProductsService productsService;
	
	
	@GetMapping("/autos")
	public String getProductsPage(Model model) {
		model.addAttribute("products", products);	
		model.addAttribute("productslines", productslinesService.obtenerProductLines());
		if(productslinesService.obtenerProductLines().isEmpty()) {
			model.addAttribute("bandera", false);
		}else {
			model.addAttribute("bandera", true);

		}
		return "productos";
	}

	
	@PostMapping("/products-save")
	public ModelAndView getGuardarProductsPage(@Valid @ModelAttribute("products")Products products, BindingResult resultadoValidacion) {
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()) {
		modelView= new ModelAndView("new-products"); 
		List<ProductLines> productslines = productslinesService.obtenerProductLines();
		modelView.addObject("products", products);
		modelView.addObject("productslines", productslines);
		modelView.addObject("bandera", true);
		return modelView;
		
	
		}
		
		else {
		ModelAndView model = new ModelAndView("products");
		
		Optional<ProductLines> productslines = productslinesService.getProductolinesPorId(products.getProductLines().getId());
		
		productslines.ifPresent(products::setProductLines);
		
	
		productsService.guardarProducts(products);
		model.addObject("products", productsService.obtenerProducts());
		model.addObject("product",products);
		return model;
		}		
		
	}

	@GetMapping("/products-list")
	public ModelAndView getComprasPage() {
		ModelAndView model = new ModelAndView("compras");
		
		model.addObject("product", products);
		model.addObject("products", productsService.obtenerProducts());
		
		return model;
	
	}
	@GetMapping("/products-eliminar-{id}")
	public ModelAndView getProductsEliminarPage(@PathVariable (value = "id")Long id) {
		ModelAndView modelView = new ModelAndView("redirect:/products-list");
		productsService.eliminarProducts(id);
		return modelView;
}
	
	@GetMapping("/products-editar-{id}")
	public ModelAndView getProductsEditPage(@PathVariable (value = "id") Long id) {

		ModelAndView modelView = new ModelAndView("new-products");
		
		Optional<Products> products = productsService.obtenerProductsPorId(id);
		
		List<ProductLines> productslines = productslinesService.obtenerProductLines();
		modelView.addObject("bandera", true);
		modelView.addObject("products", products);
		modelView.addObject("productslines", productslines);
		
		
		return modelView;
}
	@PostMapping("/products-busqueda")
	public String buscarProducts(Model model, @ModelAttribute(name="product") Products products){
		
		
		model.addAttribute("product", products);
	    model.addAttribute("products", productsService.buscarProducts(products.getProductLines().getProductLinesName()));
	    return "products";
	}
}