package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

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


@Controller
public class productLinesController {
    @Autowired
    private ProductLines productlines;
    @Autowired
	@Qualifier("productLinesMysql")
	private IProductLinesService productolinesService;
    
    
    @GetMapping("/productlines")
	public String getProductoPage(Model model) {
		model.addAttribute(productlines);
		return "product-lines";
    }
		@PostMapping("/productlines-guardar")
		public ModelAndView ProductLinesPage(@Valid @ModelAttribute("productlines") ProductLines productlines, BindingResult resultadoValidacion){
			
			//////// validation
			ModelAndView modelView;
			if(resultadoValidacion.hasErrors()) {
			modelView= new ModelAndView("product-lines"); 
			return modelView;
			}
			
			else {
				 modelView = new ModelAndView("lista-productlines");
				 productolinesService.guardarProductlines(productlines);
			modelView.addObject("productslines", productolinesService.obtenerProductlines());
			
			return modelView;
			}
		}
		@GetMapping("/productolines-eliminar-{id}")
		public ModelAndView getProductolinesEliminarPage(@PathVariable (value = "id")Long id) {
			//									redirect recarga la lista de cuentas
			ModelAndView modelView = new ModelAndView("redirect:/lista-productlines");
			productolinesService.eliminarProductolines(id);
			return modelView;
}
		
		
		@GetMapping("/productolines-editar-{id}")
		public ModelAndView getProductolinesEditPage(@PathVariable (value = "id") Long id) {
		
			
			ModelAndView modelView = new ModelAndView("product-lines");
			Optional<ProductLines> productlines = productolinesService.getProductolinesPorId(id);
			modelView.addObject("productlines", productlines);
			return modelView;
}
}
