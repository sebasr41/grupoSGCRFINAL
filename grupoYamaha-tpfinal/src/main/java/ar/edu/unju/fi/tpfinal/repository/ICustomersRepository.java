package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Customers;

public interface ICustomersRepository extends CrudRepository<Customers, Long>{
	List<Customers> findByEmployeesEmployeeNumber(Long employeeNumber);
}
