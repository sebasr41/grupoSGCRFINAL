package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Employee;


/**
 *Es una interfaz que se extiende a los metodos de crudrepository utilizandolos 
 *para la entidad  Employee que tiene una clave primaria valores Long.
 *y que crea un metodo de de busqueda de OfficeCode, employeeNumber
 */  
public interface IEmployeeRepository extends CrudRepository < Employee, Long>{
	
	List<Employee> findByOfficesOfficeCode(Long officeCode);
	List<Employee> findByEmployeesEmployeeNumber(Long employeeNumber);

}
