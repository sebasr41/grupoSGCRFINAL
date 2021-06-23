package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Employees;

public interface IEmployeesRepository extends CrudRepository < Employees, Long>{
	
	List<Employees> findByOfficesOfficeCode(Long officeCode);
	List<Employees> findByEmployeesEmployeeNumber(Long employeeNumber);

}