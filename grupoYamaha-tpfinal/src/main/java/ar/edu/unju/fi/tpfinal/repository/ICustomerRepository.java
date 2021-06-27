package ar.edu.unju.fi.tpfinal.repository;
/**
 * 
 * @author RCGS
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Customer;

/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
 *para la entidad  Customer que tiene una clave primaria con valores Long.
 *y que crea un metodo de busqueda de codigo de Numero de empleado (employeeNumber)
 */  
public interface ICustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByEmployeesEmployeeNumber(Long employeeNumber);
}
