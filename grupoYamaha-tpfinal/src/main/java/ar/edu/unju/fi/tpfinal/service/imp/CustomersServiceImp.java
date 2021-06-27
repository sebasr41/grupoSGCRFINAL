package ar.edu.unju.fi.tpfinal.service.imp;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.repository.ICustomerRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
/**
 *
 */
@Service
public class CustomersServiceImp implements ICustomersService{
	
	@Autowired
	private ICustomerRepository customersRepository;
	/**
	 *
	 */
	@Override
	public Customer guardarCustomers(Customer customers) {
		// TODO Auto-generated method stub
		return customersRepository.save(customers);
	}
	/**
	 *
	 */
	@Override
	public void eliminarCustomers(Long id) {
		// TODO Auto-generated method stub
		customersRepository.deleteById(id);
	}
	/**
	 *
	 */
	@Override
	public List<Customer> obtenerCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers= (List<Customer>) customersRepository.findAll();
		return customers;
	}
	/**
	 *
	 */
	@Override
	public Optional<Customer> getCustomersPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Customer> customers = customersRepository.findById(id);
		return customers;
	}
	/**
	 *
	 */
	@Override
	public List<Customer> obtenerCustomersPorEmployeeNumber(Long employeeNumber) {
		List<Customer> customers = customersRepository.findByEmployeesEmployeeNumber(employeeNumber);
		return customers;
	}

}
