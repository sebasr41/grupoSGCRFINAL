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
 * 
 *
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    boolean existsByRolNombre(RolNombre rolNombre);
}
