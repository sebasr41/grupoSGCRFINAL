package ar.edu.unju.fi.tpfinal.config;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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

    @Autowired
    RolService rolService;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    IEmployeesService employesService;
    
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
		    	
		    	passwordEncoded = passwordEncoder.encode("iplaygame25");
		    	usuario1.setNombreUsuario("mike47k");
		    	usuario1.setPassword(passwordEncoded);
		    	usuario1.setRoles(roles);
		    	usuarioService.save(usuario1);
		    	
		    	passwordEncoded = passwordEncoder.encode("2021gam");
		    	usuario2.setPassword(passwordEncoded);
		    	usuario2.setNombreUsuario("gabriel01");
		    	usuario2.setRoles(roles);
		    	usuarioService.save(usuario2);
		    	
		    	passwordEncoded = passwordEncoder.encode("admin");
		    	usuario3.setNombreUsuario("roxy");
		    	usuario3.setPassword(passwordEncoded);
		    	usuario3.setRoles(roles);
		    	usuarioService.save(usuario3);
		    	
		    	
		    	
		    	
		    	
			}
        	
        	
		}
    	
    }
}
