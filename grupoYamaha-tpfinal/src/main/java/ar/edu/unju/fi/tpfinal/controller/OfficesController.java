package ar.edu.unju.fi.tpfinal.controller;
/**
 * author CGRS
 */
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

import ar.edu.unju.fi.tpfinal.model.Office;

import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.IOfficesService;
/**
 *  * Esta anotacion @Controller indica que tiene pequeaas tareas derivada de la clase controller.
 * Aqui se responde a la interacción (eventos) que hace el usuario en la interfaz 
 * y realiza las peticiones necesarias (a la interfaces, clases,etc) para obtener lo que pide la vista.
 * 
 */
@Controller
public class OfficesController {
	@Autowired
	private Office offices;
	@Autowired
	private IOfficesService officesService;
	
	@Autowired
	private IEmployeesService employeesService;
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo GeMapping. Para form de offices.
	 * @param model
	 * @return formulario de oficinas.
	 */
	@GetMapping("/offices")
	public String getOfficesPage(Model model) {
		model.addAttribute("offices",offices);
		
		return "nueva-oficina";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo PostMapping. Guardar los datos obtenidos
	 * @param offices
	 * @param resultadoValidacion
	 * @return Si hay errores retorna el form, sino la lista de oficinas.
	 */
	@PostMapping("/offices-guardar")
	public ModelAndView guardarOfficesPage(@Valid @ModelAttribute("offices") Office offices, BindingResult resultadoValidacion){
		ModelAndView modelView;
		if(resultadoValidacion.hasErrors()) {
		modelView= new ModelAndView("nueva-oficina"); 
		return modelView;
		}
		else {
			 modelView = new ModelAndView("lista-oficina");
		officesService.guardarOffices(offices);
		modelView.addObject("offices", officesService.obtenerOffices());
		return modelView;
		
		}
		
		}
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * @Metodo GetMapping. Muestra lista de oficinas
	 * @return lista de oficinas
	 */
	@GetMapping("/offices-list")
	public ModelAndView getOfficesPage() {
		ModelAndView model = new ModelAndView("lista-oficina");
		model.addObject("offices", officesService.obtenerOffices());
	
		return model;

}
	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo GetMapping. Para eliminar oficinas.
	 * @param id
	 * @param attribute
	 * @return Si la oficina no tiene empleados se elimina, sino retorna la misma pagina.
	 */
	@GetMapping("/office-eliminar-{id}")
	public ModelAndView getOfficesEliminarPage(@PathVariable(value = "id") long id, RedirectAttributes attribute) {
		ModelAndView modelView = new ModelAndView("redirect:/offices-list");
		
			
		
			if (employeesService.obtenerEmployeesPorOfficeCode(id).isEmpty()) {
				officesService.eliminarOffices(id);
				attribute.addFlashAttribute("warning", "Oficina eliminado con exito");
					
			}else {
				attribute.addFlashAttribute("warning", "No se puede eliminar, la Oficina ya tiene empleados ");
			}
		
		return modelView;
	}

	@PreAuthorize("hasRole('ADMIN')")
	/**
	 * Metodo GetMapping. Retorna el form para editar.
	 * @param id
	 * @return formulario
	 */
	@GetMapping("/office-editar-{id}")
	public ModelAndView getOfficeEditPage(@PathVariable(value = "id") long id) {

		ModelAndView modelView = new ModelAndView("nueva-oficina");

		Optional<Office> offices = officesService.getOfficesPorId(id);

		modelView.addObject("offices",offices);
		

		return modelView;
	}
	
}
