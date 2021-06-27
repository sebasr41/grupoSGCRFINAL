package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Office;

/**
 * ICustomersService Esta interfaz permite minimizar el acomplamiento entre clases
 * y tiene creado dentro de si los metodos Guardar, eliminar, listar y obtener, Optional,
 * Listar y obtener de la clase Customer 
 */
public interface IOfficesService {
	/**
	 * Método guardar  
	 * @param offices
	 * @return
	 */
	public Office guardarOffices(Office offices);
	/**
	 * Método eliminar
	 * @param id
	 */
	public void eliminarOffices(Long id);
	/**
	 * Método Listar
	 * @return
	 */
	public List<Office> obtenerOffices();
	/**
	 * Método variable OPTIONAL
	 * @param id
	 * @return
	 */
	public Optional<Office> getOfficesPorId(Long id);
	

}