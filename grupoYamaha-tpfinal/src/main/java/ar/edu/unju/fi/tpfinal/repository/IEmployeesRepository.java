package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;


import ar.edu.unju.fi.tpfinal.model.Employees;

public interface IEmployeesRepository extends CrudRepository < Employees, Long>{

	public Employees findByNomusuario(String nomusuario);

	
}
