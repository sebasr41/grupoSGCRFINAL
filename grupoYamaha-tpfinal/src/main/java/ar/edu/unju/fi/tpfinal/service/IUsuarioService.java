package ar.edu.unju.fi.tpfinal.service;


import ar.edu.unju.fi.tpfinal.model.Usuario;
//capa de service
public interface IUsuarioService {
	
	//Metodo para buscar por nombre de usuario
	public Usuario findByNombreUsuario(String nombreUsuario);

}
