package ar.edu.unju.fi.tpfinal.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.ProductLines;
import ar.edu.unju.fi.tpfinal.service.IProductLinesService;


@Controller
public class ProductLinesController {
	
    @Autowired
    private ProductLines productlines;
    
    @Autowired
	private IProductLinesService productolinesService;
    
    
    @GetMapping("/productlines")
	public String getProductoPage(Model model) {
		productlines.setImage("");
		model.addAttribute("productlines",productlines);
		return "nueva-categoria";
    }
		@PostMapping("/productlines-guardar")
		public ModelAndView ProductLinesPage(@Valid @ModelAttribute("productlines") ProductLines productlines, @RequestParam("file") MultipartFile image, BindingResult resultadoValidacion) throws IOException{
			
			//////// validation
			ModelAndView modelView;
			//if(resultadoValidacion.hasErrors()) {
			//modelView= new ModelAndView("nueva-categoria"); 
			//return modelView;
			//}
			
			//else {
				 modelView = new ModelAndView("lista-categoria");
				 if (!image.isEmpty()) {
					Path directorioImagenes = Paths.get("src//main//resources//static/img");
					String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
					try {
						byte[] bytesImg = image.getBytes();
						Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + image.getOriginalFilename());
						Files.write(rutaCompleta, bytesImg);
	
						productlines.setImage(image.getOriginalFilename());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				 productolinesService.guardarProductLines(productlines);
			modelView.addObject("productslines", productolinesService.obtenerProductLines());
			
			return modelView;
			//}
		}
		@GetMapping("/productLines-list")
		public ModelAndView getComprasPage() {
			ModelAndView model = new ModelAndView("lista-categoria");
			
			model.addObject("productslines", productolinesService.obtenerProductLines());
			

			
			return model;
		
		}
		@GetMapping("/productolines-eliminar-{id}")
		public ModelAndView getProductolinesEliminarPage(@PathVariable (value = "id")String id) {
			//									redirect recarga la lista de cuentas
			ModelAndView modelView = new ModelAndView("redirect:/lista-productlines");
			productolinesService.eliminarProductLines(id);
			return modelView;
}
		
		
		@GetMapping("/productolines-editar-{id}")
		public ModelAndView getProductolinesEditPage(@PathVariable (value = "id") String id) {
		
			
			ModelAndView modelView = new ModelAndView("product-lines");
			Optional<ProductLines> productlines = productolinesService.getProductolinesPorId(id);
			modelView.addObject("productlines", productlines);
			return modelView;
}
}
