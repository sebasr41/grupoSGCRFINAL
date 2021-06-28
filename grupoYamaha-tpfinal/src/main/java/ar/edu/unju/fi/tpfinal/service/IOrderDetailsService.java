package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;

/**
 * ICustomersService Esta interfaz permite minimizar el acomplamiento entre clases
 * y tiene creado dentro de si los metodos Guardar, eliminar, listar y obtener, Optional,
 * Listar y obtener de la clase Customer 
 */
public interface IOrderDetailsService {
    /**
     * Método guardar 
     * @param orderDetails
     * @return
     */
	public OrderDetail guardarOrderDetails(OrderDetail orderDetails);
	/**
	 * Método listar
	 * @return
	 */
	public List<OrderDetail> obtenerOrderDetails();
	/**
	 * Método de la variable OPTIONAL
	 * @param id
	 * @return
	 */
	public Optional<OrderDetail> obtenerOrderDetailsPorId(Long id);
	/**
	 * Método eliminar
	 * @param id
	 */
	public void eliminarOrderDetails(Long id);
	/**
	 * Método Listar
	 * @param productCode
	 * @return
	 */
	public List<OrderDetail> obtenerOrderDetailsporProductCode(String productCode);
	/**
	 * Método Listar por customer number
	 * @param customerNumber
	 * @return
	 */
	public List<OrderDetail> obtenerOrderDetailsporCustomerNumber(Long customerNumber);

    
}