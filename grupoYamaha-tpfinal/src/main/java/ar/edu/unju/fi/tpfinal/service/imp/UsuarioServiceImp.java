package ar.edu.unju.fi.tpfinal.service.imp;


import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.repository.IUsuarioRepository;
import ar.edu.unju.fi.tpfinal.service.IUsuarioService;

public class UsuarioServiceImp implements IUsuarioService{

	//inyeccion de un objeto implementador de la cpa de repository
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	//implementamos el metodo de la capa de interfaz
	@Override
	public Usuario findByNombreUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		Usuario us = usuarioRepository.findByNombreUsuario(nombreUsuario);
		return us;
	}
	
	
	

}
