package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employees;
import ar.edu.unju.fi.tpfinal.model.Offices;
import ar.edu.unju.fi.tpfinal.repository.IEmployeesRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.IOfficesService;

@Service

public class EmployeesServiceImp  implements IEmployeesService{

	@Autowired
	private IEmployeesRepository employeesRepository;
	
	@Autowired
	private IOfficesService officeService;
	
	
	
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

	@Override
	public void generarAdmins() {

			List<Employees> employs = (List<Employees>) employeesRepository.findAll();
		
		if(employs.isEmpty()) {
			
			Offices oficina = new Offices();
			oficina.setCity("S.S Jujuy");
			oficina = officeService.guardarOffices(oficina);
			
			Employees employ1 = new Employees();
			Employees employ2 = new Employees();
			Employees employ3 = new Employees();
			Employees employ4 = new Employees();
			Employees employ5 = new Employees();
			
			employ1.setEmail("cristianmichel33@gmail.com");
			employ1.setFirstName("Cristian");
			employ1.setLastName("Michel");
			employ1.setJobTitle("Boss");
			employ1.setOffices(oficina);
			employeesRepository.save(employ1);
			
			employ4.setEmail("roxanayvbenicio@gmail.com");
			employ4.setFirstName("Roxana");
			employ4.setLastName("Benicio");
			employ4.setJobTitle("Admin");
			employ4.setEmployees(employ1);
			employ4.setOffices(oficina);
			employeesRepository.save(employ4);
			
			employ3.setEmail("gabi@gmail.com");
			employ3.setFirstName("Gabriel");
			employ3.setLastName("Mamani");
			employ3.setJobTitle("Marketing Director");
			employ3.setEmployees(employ1);
			employ3.setOffices(oficina);
			employeesRepository.save(employ3);
			
			employ2.setEmail("SebasR432@gmail.com");
			employ2.setFirstName("Seba");
			employ2.setLastName("Rojas");
			employ2.setJobTitle("Deputy Chief");
			employ2.setEmployees(employ1);
			employ2.setOffices(oficina);
			employeesRepository.save(employ2);
			
			employ5.setEmail("fulano33@gmail.com");
			employ5.setFirstName("Anastasio");
			employ5.setLastName("Pancrasio");
			employ5.setJobTitle("SubAdmin");
			employ5.setEmployees(employ2);
			employ5.setOffices(oficina);
			employeesRepository.save(employ5);
			
			
			
			
			
			
		}
		
		
	}


}
