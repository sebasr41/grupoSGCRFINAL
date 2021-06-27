package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Customer;

/**
 * ICustomersService Esta interfaz permite minimizar el acomplamiento entre clases
 * y tiene creado dentro de si los metodos Guardar, eliminar, listar y obtener, Optional,
 * Listar y obtener de la clase Customer 
 */
public interface ICustomersService {
	/**
	 * Método guardar 
	 * @param customers
	 * @return
	 */
	public Customer guardarCustomers(Customer customers);
	/**
	 * Método eliminar atributos de Customers
	 * @param id
	 */
	public void eliminarCustomers(Long id);
	/**
	 * Metodo listar
	 * @return List<Customer>
	 */
	public List<Customer> obtenerCustomers();
	 
	/**
	 * Método OPTIONAL (se refiere a que  puede tener valor nulo o tener valor
	 * (objeto podrìa o no encontrarse en un Set de Customer))
	 * @param id
	 * @return Optional<Customer>
	 */
	public Optional<Customer> getCustomersPorId(Long id);
	
	/**
	 * Método Listar elemento de la clase Employe llamado desde Customer
	 * @param employeeNumber
	 * @return
	 */
	public List<Customer> obtenerCustomersPorEmployeeNumber(Long employeeNumber);

	
}
