package ar.edu.unju.fi.tpfinal.config;
/**
 * 
 * @author RCGS 
 *
 */

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.enums.RolNombre;
import ar.edu.unju.fi.tpfinal.model.Rol;
import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.RolService;
import ar.edu.unju.fi.tpfinal.service.UsuarioService;

@Service
public class CreateRoles implements CommandLineRunner {
	//Autowired Inyecta la dependencia, o enlaza RolService con CreateRoles
    @Autowired
    RolService rolService;
    //Autowired Inyecta la dependencia, o enlaza UsuarioService con CreateRoles
    @Autowired
    UsuarioService usuarioService;
    
    //Autowired Inyecta la dependencia, o enlaza IEmployeesService con CreateRoles
    @Autowired
    IEmployeesService employesService;
    
    //Autowired Inyecta la dependencia, o enlaza PasswordEncoder con CreateRoles
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    	
    	if (rolService.verificar().isEmpty()) {
    		Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        	Rol rolUser = new Rol(RolNombre.ROLE_USER);
        	rolService.save(rolAdmin);
        	rolService.save(rolUser);
        	
        	if (usuarioService.lista().isEmpty()) {
        		employesService.generarAdmins();
				Usuario usuario = new Usuario();
				Usuario usuario1 = new Usuario();
				Usuario usuario2 = new Usuario();
				Usuario usuario3 = new Usuario();

				//**Creacion de usuario( usuario y contraseña), con ROL _ADMIN
			    	String passwordEncoded = passwordEncoder.encode("seba001");
			    	usuario.setNombreUsuario("10sebastian");
			    	usuario.setPassword(passwordEncoded);
			    	rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
			    	rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
			    	Set<Rol> roles = new HashSet<>();
			    	roles.add(rolAdmin);
			    	roles.add(rolUser);
			    	usuario.setRoles(roles);
			    	usuarioService.save(usuario);
			    	//**Creacion de usuario1( usuario y contraseña), con ROL _ADMIN
			    	passwordEncoded = passwordEncoder.encode("iplaygame25");
			    	usuario1.setNombreUsuario("mike47k");
			    	usuario1.setPassword(passwordEncoded);
			    	usuario1.setRoles(roles);
			    	usuarioService.save(usuario1);
			    	//**Creacion de usuario2( usuario y contraseña), con ROL _ADMIN
			    	passwordEncoded = passwordEncoder.encode("2021gam");
			    	usuario2.setPassword(passwordEncoded);
			    	usuario2.setNombreUsuario("gabriel01");
			    	usuario2.setRoles(roles);
			    	usuarioService.save(usuario2);
			    	//**Creacion de usuario3( usuario y contraseña), con ROL _ADMIN
			    	//Contrasea de roxy 
			    	passwordEncoded = passwordEncoder.encode("admin");
			    	//Usuario roxy
			    	usuario3.setNombreUsuario("roxy");
			    	usuario3.setPassword(passwordEncoded);
			    	usuario3.setRoles(roles);
			    	usuarioService.save(usuario3);
		    	
		    	
		    	
			}
        	
        	
		}
    	
    }
}
