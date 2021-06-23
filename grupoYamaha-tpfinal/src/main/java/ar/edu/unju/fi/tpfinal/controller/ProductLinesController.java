package ar.edu.unju.fi.tpfinal.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import ar.edu.unju.fi.tpfinal.model.Products;
import ar.edu.unju.fi.tpfinal.service.IProductLinesService;

@Controller
public class ProductLinesController {

	@Autowired
	private ProductLines productlines;

	@Autowired
	private IProductLinesService productolinesService;
	@Autowired
	private Products products;

	@GetMapping("/productlines")
	public String getProductLinesPage(Model model) {
		productlines.setImage("");
		model.addAttribute("productlines", productlines);
		return "nueva-categoria";
	}

	@PostMapping("/productlines-guardar")
	public ModelAndView ProductLinesPage(@Valid @ModelAttribute("productlines") ProductLines productlines,
			@RequestParam("file") MultipartFile file, BindingResult resultadoValidacion) throws IOException {
		//////// validation
		ModelAndView modelView;
		if (resultadoValidacion.hasErrors()) {


			modelView = new ModelAndView("nueva-categoria");
			modelView.addObject("productlines", productlines);
			return modelView;
		}

		else {
			modelView = new ModelAndView("lista-categoria");
			if (!file.isEmpty()) {
				// linux
				String rutaAbsoluta = "/home/mike47k/imagPvisual"; // directorioImagenes.toFile().getAbsolutePath();

				/// grupoYamaha-tpfinal/src/main/resources/static/img
				// Path directorioImagenes = Paths.get("src//main//resources//static/img");
				// String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

				try {
					byte[] bytesImg = file.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "/" + file.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);

					productlines.setImage(file.getOriginalFilename());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			productolinesService.guardarProductLines(productlines);
			System.out.println(productlines.getImage());
			modelView.addObject("productslines", productolinesService.obtenerProductLines());
			modelView.addObject("product", products);
			return modelView;
		}
	}

	@GetMapping("/productLines-list")
	public ModelAndView getProductLinesPage() {
		ModelAndView model = new ModelAndView("lista-categoria");

		model.addObject("productslines", productolinesService.obtenerProductLines());
		model.addObject("product", products);
		return model;

	}

	@GetMapping("/productolines-eliminar-{id}")
	public ModelAndView getProductolinesEliminarPage(@PathVariable(value = "id") String id) {
		// redirect recarga la lista de cuentas
		ModelAndView modelView = new ModelAndView("redirect:/lista-productlines");
		productolinesService.eliminarProductLines(id);
		return modelView;
	}

	@GetMapping("/productolines-editar-{id}")
	public ModelAndView getProductolinesEditPage(@PathVariable(value = "id") String id) {

		ModelAndView modelView = new ModelAndView("product-lines");
		Optional<ProductLines> productlines = productolinesService.getProductolinesPorId(id);
		modelView.addObject("productlines", productlines);
		return modelView;
	}
}
