package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employee;
import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.repository.IEmployeeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeesService;
import ar.edu.unju.fi.tpfinal.service.IOfficesService;
/**
*
*/
@Service
public class EmployeesServiceImp  implements IEmployeesService{

	@Autowired
	private IEmployeeRepository employeesRepository;
	
	@Autowired
	private IOfficesService officeService;
	
	
	/**
	 *
	 */
	@Override
	public void guardarEmployees(Employee employees) {
		// TODO Auto-generated method stub
		employeesRepository.save(employees);
	}
	/**
	 *
	 */
	@Override
	public void eliminarEmployees(Long id) {
		employeesRepository.deleteById(id);
		
	}
	/**
	 *
	 */
	@Override
	public List<Employee> obtenerEmployees() {
		
		List<Employee> employees= (List<Employee>) employeesRepository.findAll();
		return employees;
	}
	/**
	 *
	 */
	@Override
	public Optional<Employee> getEmployeesPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employees = employeesRepository.findById(id);
		return employees;
	}
	/**
	 *
	 */
	@Override
	public void generarAdmins() {

			List<Employee> employs = (List<Employee>) employeesRepository.findAll();
		
		if(employs.isEmpty()) {
			
			Office oficina = new Office();
			oficina.setCity("S.S Jujuy");
			oficina.setAddressLine1("Italo Palanca");
			oficina.setAddressLine2("SUITE 300");
			oficina.setCountry("Argentina");
			oficina.setPhone(388412345);
			oficina.setPostalCode("4600");
			oficina.setState("Jujuy");
			oficina.setTerritory("LAS");
			oficina = officeService.guardarOffices(oficina);
			
			Employee employ1 = new Employee();
			Employee employ2 = new Employee();
			Employee employ3 = new Employee();
			Employee employ4 = new Employee();
			Employee employ5 = new Employee();
			
			employ1.setEmail("cristianmichel33@gmail.com");
			employ1.setFirstName("Cristian");
			employ1.setLastName("Michel");
			employ1.setJobTitle("CEO");
			employ1.setOffices(oficina);
			employ1.setExtension("x1000");
			
			employeesRepository.save(employ1);
			
			employ4.setEmail("roxanayvbenicio@gmail.com");
			employ4.setFirstName("Roxana");
			employ4.setLastName("Benicio");
			employ4.setJobTitle("Customer Maanager");
			employ4.setExtension("x1000");
			employ4.setEmployees(employ1);
			employ4.setOffices(oficina);
			employeesRepository.save(employ4);
			
			employ3.setEmail("gabi@gmail.com");
			employ3.setFirstName("Gabriel");
			employ3.setLastName("Mamani");
			employ3.setJobTitle("Marketing Director");
			employ3.setExtension("x1000");
			employ3.setEmployees(employ1);
			employ3.setOffices(oficina);
			employeesRepository.save(employ3);
			
			employ2.setEmail("SebasR432@gmail.com");
			employ2.setFirstName("Seba");
			employ2.setLastName("Rojas");
			employ2.setJobTitle("Executive Director");
			employ2.setExtension("x1000");
			employ2.setEmployees(employ1);
			employ2.setOffices(oficina);
			employeesRepository.save(employ2);
			
			employ5.setEmail("fulano33@gmail.com");
			employ5.setFirstName("Anastasio");
			employ5.setLastName("Pancrasio");
			employ5.setJobTitle("SubAdmin");
			employ5.setExtension("x1000");
			employ5.setEmployees(employ2);
			employ5.setOffices(oficina);
			employeesRepository.save(employ5);
			
			
			
			
			
			
		}
		
		
	}
	/**
	 *
	 */
	@Override
	public List<Employee> obtenerEmployeesPorOfficeCode(Long officeCode) {
		List<Employee> empleados = employeesRepository.findByOfficesOfficeCode(officeCode);
		return empleados;
	}
	/**
	 *
	 */
	@Override
	public List<Employee> obtenerEmployeesPorEmployeesNumber(Long employeesNumber) {
		List<Employee> empleados = employeesRepository.findByEmployeesEmployeeNumber(employeesNumber);
		return empleados;
	}


}
