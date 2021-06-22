package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employees;
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

	@Override
	public void generarAdmins() {

			List<Employees> employs = (List<Employees>) employeesRepository.findAll();
		
		if(employs.isEmpty()) {
			Employees employ1 = new Employees();
			Employees employ2 = new Employees();
			Employees employ3 = new Employees();
			Employees employ4 = new Employees();
			Employees employ5 = new Employees();
			
			employ1.setEmail("cristianmichel33@gmail.com");
			employ1.setFirstName("Cristian");
			employ1.setLastName("Michel");
			employ1.setJobTitle("The Boss");
			employ1.setEmployees(null);
			employeesRepository.save(employ1);
			
			employ2.setEmail("roxanayvbenicio@gmail.com");
			employ2.setFirstName("Roxana");
			employ2.setLastName("Benicio");
			employ2.setJobTitle("Admin");
			employ2.setEmployees(employ1);
			employeesRepository.save(employ2);
			
			employ3.setEmail("gabi@gmail.com");
			employ3.setFirstName("Gabriel");
			employ3.setLastName("Mamani");
			employ3.setJobTitle("Admin");
			employ3.setEmployees(employ1);
			employeesRepository.save(employ3);
			
			employ4.setEmail("seba@gmail.com");
			employ4.setFirstName("Seba");
			employ4.setLastName("Rojas");
			employ4.setJobTitle("Jefe");
			employ4.setEmployees(employ3);
			employeesRepository.save(employ4);
			
			employ5.setEmail("fulano33@gmail.com");
			employ5.setFirstName("Anastasio");
			employ5.setLastName("Pancrasio");
			employ5.setJobTitle("SubAdmin");
			employ5.setEmployees(employ2);
			employeesRepository.save(employ5);			
		}
	}


	/*
	 * Codigo paara el metodo de security
	 */

	@Override
	public Employees findByNomsuario(String nomusuario) {
		// TODO Auto-generated method stub
		Employees em = employeesRepository.findByNomusuario(nomusuario);
		return em;
	}
}
