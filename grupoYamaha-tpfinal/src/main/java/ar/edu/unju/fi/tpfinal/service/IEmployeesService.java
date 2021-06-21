package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Employees;
;

public interface IEmployeesService {
	public void guardarEmployees(Employees employees);

	
	public void eliminarEmployees(Long id);

	public List<Employees> obtenerEmployees();

	public Optional<Employees> getEmployeesPorId(Long id);
	
	public void generarAdmins();
	
	public List<Employees> obtenerEmployeesPorOfficeCode(Long officeCode);

}
