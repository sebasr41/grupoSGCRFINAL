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
public class UsuarioDetailServiceImp implements UserDetailsService{

	@Autowired
	IUsuarioRepository usuarioRepository;
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario =usuarioRepository.findByNombreUsuario(username);
		UserBuilder builder =null;
		
		if(usuario !=null) {
			builder =User.withUsername(username);
			builder.password(usuario.getPassword());
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new SimpleGrantedAuthority(usuario.getRol()));
			builder.authorities(roles);	
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return builder.build();
	}

	
	
	
	
}











