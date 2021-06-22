package ar.edu.unju.fi.tpfinal.repository;



import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{

	public Usuario findByNombreUsuario(String nombreUsuario);


}
