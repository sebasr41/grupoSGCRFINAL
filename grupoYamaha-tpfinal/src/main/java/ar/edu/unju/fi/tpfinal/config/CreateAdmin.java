package ar.edu.unju.fi.tpfinal.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.enums.RolNombre;
import ar.edu.unju.fi.tpfinal.model.Rol;
import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.service.RolService;
import ar.edu.unju.fi.tpfinal.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreateAdmin implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
    	/**  if (!rolService.verificar().isEmpty()) {
			if (usuarioService.lista().isEmpty()) {
				Usuario usuario = new Usuario();
		    	String passwordEncoded = passwordEncoder.encode("admin");
		    	usuario.setNombreUsuario("admin");
		    	usuario.setPassword(passwordEncoded);
		    	Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
		    	Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
		    	Set<Rol> roles = new HashSet<>();
		    	roles.add(rolAdmin);
		    	roles.add(rolUser);
		    	usuario.setRoles(roles);
		    	usuarioService.save(usuario);
			}
		}
    	
    	
    	Usuario usuario = new Usuario();
    	String passwordEncoded = passwordEncoder.encode("admin");
    	usuario.setNombreUsuario("admin");
    	usuario.setPassword(passwordEncoded);
    	Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
    	Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
    	Set<Rol> roles = new HashSet<>();
    	roles.add(rolAdmin);
    	roles.add(rolUser);
    	usuario.setRoles(roles);
    	usuarioService.save(usuario);
        */
    }
}
