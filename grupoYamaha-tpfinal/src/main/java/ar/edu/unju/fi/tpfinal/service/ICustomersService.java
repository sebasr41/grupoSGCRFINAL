package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Customers;


public interface ICustomersService {
	
	public void guardarCustomers(Customers customers);

	public void eliminarCustomers(Long id);

	public List<Customers> obtenerCustomers();

	public Optional<Customers> getCustomersPorId(Long id);
	
	public List<Customers> obtenerCustomersPorEmployeeNumber(Long employeeNumber);

	
}
