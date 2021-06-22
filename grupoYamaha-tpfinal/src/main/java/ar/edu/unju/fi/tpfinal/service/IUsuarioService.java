package ar.edu.unju.fi.tpfinal.service;

import ar.edu.unju.fi.tpfinal.model.Usuario;

public interface IUsuarioService {
	
	public Usuario findByNombreUsuario(String nombreUsuario);
}
