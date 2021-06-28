package ar.edu.unju.fi.tpfinal.repository;
/**
 * 
 * @author RCGS
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tpfinal.enums.RolNombre;
import ar.edu.unju.fi.tpfinal.model.Rol;

import java.util.Optional;
/**
 * 
 * Es una interfaz que se extiende a los metodos de crudrepository y crea 
 *metodos genericos de busqueda par ala entidad ROl que tiene una clave primaria de tipo Integer
 *
 *
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	/**
	 * 
	 * @param rolNombre
	 * @return
	 */
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    /**
     * 
     * @param rolNombre
     * @return
     */
    boolean existsByRolNombre(RolNombre rolNombre);
}
