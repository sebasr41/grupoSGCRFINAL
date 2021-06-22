package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.repository.IUsuarioRepository;



@Service
public class UsuarioDetailsServiceImp implements UserDetailsService{

	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Override					// este username es el del formulario de login
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//recuperamos el usuario de la base de datos
		Usuario usuario = usuarioRepository.findByNombreUsuario(username);
		UserBuilder builder = null; // -> Construye los datos del usuario
		
		if(usuario !=null) {
			builder = User.withUsername(username);
			builder.password(usuario.getPassword());
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>(); 
			roles.add(new SimpleGrantedAuthority(usuario.getRol()));
			builder.authorities(roles);
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return builder.build();
	}

}
