package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Customers;
import ar.edu.unju.fi.tpfinal.repository.ICustomersRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;

@Service
public class CustomersServiceImp implements ICustomersService{

	@Autowired
	private ICustomersRepository customersRepository;
	@Override
	public void guardarCustomers(Customers customers) {
		// TODO Auto-generated method stub
		customersRepository.save(customers);
	}

	@Override
	public void eliminarCustomers(Long id) {
		// TODO Auto-generated method stub
		customersRepository.deleteById(id);
	}

	@Override
	public List<Customers> obtenerCustomers() {
		// TODO Auto-generated method stub
		List<Customers> customers= (List<Customers>) customersRepository.findAll();
		return customers;
	}

	@Override
	public Optional<Customers> getCustomersPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Customers> customers = customersRepository.findById(id);
		return customers;
	}

}
