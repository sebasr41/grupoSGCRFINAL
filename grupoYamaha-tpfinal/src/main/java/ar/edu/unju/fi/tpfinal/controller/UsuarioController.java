package ar.edu.unju.fi.tpfinal.controller;
/**
 * author CGRS
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang3.StringUtils;

import ar.edu.unju.fi.tpfinal.enums.RolNombre;
import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Rol;
import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.RolService;
import ar.edu.unju.fi.tpfinal.service.UsuarioService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;
/**
 * Esta anotacion @Controller indica que tiene pequeaas tareas derivada de la clase controller.
 * Aqui se responde a la interacción (eventos) que hace el usuario en la interfaz 
 * y realiza las peticiones necesarias (a la interfaces, clases,etc) para obtener lo que pide la vista.
 * 
 */
@Controller
public class UsuarioController {
	
	@Autowired
	ICustomersService customerService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    Usuario usuario;
    
    @Autowired
    IEmployeesService employeService;
    
    /**
     * Metodo GetMapping.
     * @param model
     * @return form de usuario de registro.
     */
    @GetMapping("/usuario-registro")
    public String registro(Model model){
    	model.addAttribute("usuario", usuario);
        return "registro";
    }

    /**
     * Metodo PostMapping. Para guardar datos.
     * @param usuario
     * @return si hay errores el form de registro, sino crea la cuenta.
     */
    @PostMapping("/usuario-registrar")
    public ModelAndView registrar(@Valid @ModelAttribute("usuario") Usuario usuario,final BindingResult resultadoValidacion) throws Exception{
        ModelAndView mv = new ModelAndView();
        if (resultadoValidacion.hasErrors()) {
        	 ModelAndView mov = new ModelAndView("registro");
        	 mov.addObject("usuario", usuario);
			return mov;
		}else {
			if(StringUtils.isBlank(usuario.getNombreUsuario())){
	            mv.setViewName("/usuario-registro");
	            mv.addObject("error", "el nombre no puede estar vacío");
	            return mv;
	        }
	        if(StringUtils.isBlank(usuario.getPassword())){
	            mv.setViewName("/usuario-registro");
	            mv.addObject("error", "la contraseña no puede estar vacía");
	            return mv;
	        }
	        if(usuarioService.existsByNombreusuario(usuario.getNombreUsuario())){
	            mv.setViewName("/usuario-registro");
	            mv.addObject("error", "ese nombre de usuario ya existe");
	            return mv;
	        }
	        // una vez seteada la password , se codifica.
	        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
	        Set<Rol> roles = new HashSet<>();
	        roles.add(rolUser);
	        usuario.setRoles(roles);
	        //seteamos  un empleado en customer automaticamente luego guardamos y a la vez seteamos lo guardado en usuario y despues guardamos usuario
	        Customer custom = usuario.getCustomers();
	        Optional<Employee> gerente= employeService.getEmployeesPorId((long) 2);
	        custom.setEmployees(gerente.get());
	        usuario.setCustomers(customerService.guardarCustomers(custom));
	        
	        usuarioService.save(usuario);
	        mv.setViewName("/login");
	        mv.addObject("registroOK", "Cuenta creada, " + usuario.getNombreUsuario() + ", ya puedes iniciar sesión");
	        return mv;
		}
        
    }



}
