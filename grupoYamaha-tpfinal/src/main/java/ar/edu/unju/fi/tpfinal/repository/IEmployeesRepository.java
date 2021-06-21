package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Employees;
import ar.edu.unju.fi.tpfinal.model.Offices;

public interface IEmployeesRepository extends CrudRepository < Employees, Long>{
	
	List<Employees> findByOfficesOfficeCode(Long officeCode);

}
