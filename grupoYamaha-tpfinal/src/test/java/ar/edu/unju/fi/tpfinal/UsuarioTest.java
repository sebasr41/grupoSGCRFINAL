package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.repository.IUsuarioRepository;



@SpringBootTest
class UsuarioTest {
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Test
	void testGuardarUsuario() {
		/***
		 * 
		usuario.setNombreUsuario("Gabriel");
		usuario.setPassword(encoder.encode("123"));
		usuario.setRol("ADMIN");
		 * 
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("Alejadnro");
		usuario.setPassword(encoder.encode("321"));
		usuario.setRol("EDITOR");
		 */
		/***
		 * 
		Usuario us = usuarioRepository.save(usuario);
		assertEquals(us.getNombreUsuario(),usuario.getNombreUsuario());
		 * 
		 */
	}

}
