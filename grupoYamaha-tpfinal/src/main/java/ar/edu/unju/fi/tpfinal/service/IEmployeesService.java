package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Employee;

/**
 * ICustomersService Esta interfaz permite minimizar el acomplamiento entre clases
 * y tiene creado dentro de si los metodos Guardar, eliminar, listar y obtener, Optional,
 * Listar y obtener de la clase Customer 
 */
public interface IEmployeesService {
	/**
	 * Metodo Guardar
	 * @param employees
	 */
	public void guardarEmployees(Employee employees);

	/**
	 * Metodo eliminar
	 * @param id
	 */
	public void eliminarEmployees(Long id);
	/**
	 * Metodo listar
	 * 
	 */
	public List<Employee> obtenerEmployees();
	/**
	 * Metodo OPTIONAL
	 * @param id
	 * @return
	 */
	public Optional<Employee> getEmployeesPorId(Long id);
	/**
	 * 
	 */
	public void generarAdmins();
	/**
	 * Metodo listar OfficeCode
	 * @param officeCode
	 * @return
	 */
	public List<Employee> obtenerEmployeesPorOfficeCode(Long officeCode);
	/**
	 * Metodo Employee
	 * @param employeesNumber
	 * @return
	 */
	public List<Employee> obtenerEmployeesPorEmployeesNumber(Long employeesNumber);

}
