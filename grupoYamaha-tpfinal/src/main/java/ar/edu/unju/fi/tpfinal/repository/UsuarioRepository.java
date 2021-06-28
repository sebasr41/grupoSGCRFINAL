package ar.edu.unju.fi.tpfinal.repository;
/**
 * 
 * @author RCGS
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.model.Usuario;

import java.util.List;
import java.util.Optional;
/**
 * Es una interfaz que se extiende a los metodos de crudrepository y crea 
 * metodos genericos de busqueda para la entidad Usuario que tiene una clave primaria de tipo Integer
 * contiene metodo de buscar y devolver si esta o no usario.
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	/**
	 * Metodo de Busqueda 
	 * @param nombreUsuario
	 * @return
	 */
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    /**
     * Metodo devuelve si esta  o no el nombre de usaru
     * @param nombreUsuario
     * @return
     */
    boolean existsByNombreUsuario(String nombreUsuario);
    /**
     * Metodo de Busqueda
     * @param customerNumber
     * @return
     */
    List<Usuario> findByCustomersCustomerNumber(Long customerNumber);
}
