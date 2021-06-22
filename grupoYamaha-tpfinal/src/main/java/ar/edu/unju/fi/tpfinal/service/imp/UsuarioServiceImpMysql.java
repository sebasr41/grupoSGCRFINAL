package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.repository.IUsuarioRepository;
import ar.edu.unju.fi.tpfinal.service.IUsuarioService;


public class UsuarioServiceImpMysql implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public Usuario findByNombreUsuario(String nombreUsuario) {
		Usuario us = usuarioRepository.findByNombreUsuario(nombreUsuario);
		return us;
	}

}
