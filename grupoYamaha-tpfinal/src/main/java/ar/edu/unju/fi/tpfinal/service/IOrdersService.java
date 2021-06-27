package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Order;

/**
 * ICustomersService Esta interfaz permite minimizar el acomplamiento entre clases
 * y tiene creado dentro de si los metodos Guardar, eliminar, listar y obtener, Optional,
 * Listar y obtener de la clase Customer 
 */
public interface IOrdersService {
	/**
	 * Método guardar
	 * @param orders
	 * @return
	 */
    public Order guardarOrders(Order orders);
    /**
     * Método Listar
     * @return
     */
	public List<Order> obtenerOrders();
	/**
	 * Método OPTIONAL
	 * @param id
	 * @return
	 */
    public Optional<Order> obtenerOrdersPorId(Long id);
	/**
	 * Método eliminar
	 * @param id
	 */
	public void eliminarOrders(Long id);
	/**
	 * Método Listar
	 * @param customerNumber
	 * @return
	 */
	public List<Order> obtenerOrdersPorcustomerNumber(Long customerNumber);
}
