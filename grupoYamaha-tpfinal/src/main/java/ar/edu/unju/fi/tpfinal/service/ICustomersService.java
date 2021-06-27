package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Customer;


public interface ICustomersService {
	
	public Customer guardarCustomers(Customer customers);

	public void eliminarCustomers(Long id);

	public List<Customer> obtenerCustomers();

	public Optional<Customer> getCustomersPorId(Long id);
	
	public List<Customer> obtenerCustomersPorEmployeeNumber(Long employeeNumber);

	
}
