package ar.edu.unju.fi.tpfinal.service.imp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tpfinal.model.Employees;
import ar.edu.unju.fi.tpfinal.repository.IEmployeesRepository;

@SpringBootTest
class EmployeesDetailsServiceImpTest {


	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	IEmployeesRepository esmployeesRepository;
	
	@Test
	void testGurdarUsuario() {
		 Employees employees = new Employees();
		//usuario.setUsername("maximog");
		//usuario.setPassword(encoder.encode("123456"));
		//usuario.setRol("ADMIN");
		 employees.setNomusuario("juanpimpon");
		 employees.setPassword(encoder.encode("abs12345"));;
		 employees.setRol("EDITOR");
		 Employees em = esmployeesRepository.save(employees);
		 assertEquals(em.getNomusuario(),employees.getNomusuario());
			
	}



}
