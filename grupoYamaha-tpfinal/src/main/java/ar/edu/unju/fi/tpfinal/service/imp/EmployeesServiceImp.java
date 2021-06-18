package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employees;
import ar.edu.unju.fi.tpfinal.model.Offices;
import ar.edu.unju.fi.tpfinal.repository.IEmployeesRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;

@Service

public class EmployeesServiceImp  implements IEmployeesService{

	@Autowired
	
	private IEmployeesRepository employeesRepository;
	@Override
	public void guardarEmployees(Employees employees) {
		// TODO Auto-generated method stub
		employeesRepository.save(employees);
	}

	@Override
	public void eliminarEmployees(Long id) {
		employeesRepository.deleteById(id);
		
	}

	@Override
	public List<Employees> obtenerEmployees() {
		
		List<Employees> employees= (List<Employees>) employeesRepository.findAll();
		return employees;
	}

	@Override
	public Optional<Employees> getEmployeesPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Employees> employees = employeesRepository.findById(id);
		return employees;
	}

}
