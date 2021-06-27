package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Employee;


public interface IEmployeesService {
	public void guardarEmployees(Employee employees);

	
	public void eliminarEmployees(Long id);

	public List<Employee> obtenerEmployees();

	public Optional<Employee> getEmployeesPorId(Long id);
	
	public void generarAdmins();
	
	public List<Employee> obtenerEmployeesPorOfficeCode(Long officeCode);
	
	public List<Employee> obtenerEmployeesPorEmployeesNumber(Long employeesNumber);

}
