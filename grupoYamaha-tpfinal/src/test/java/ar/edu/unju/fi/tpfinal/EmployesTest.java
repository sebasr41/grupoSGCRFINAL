package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tpfinal.model.Employees;
import ar.edu.unju.fi.tpfinal.repository.IEmployeesRepository;

@SpringBootTest
class EmployesTest {


	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	IEmployeesRepository employeesRepository;
	
	@Test
	void testGurdarUsuario() {
		 Employees employees = new Employees();
		//usuario.setUsername("maximog");
		//usuario.setPassword(encoder.encode("123456"));
		//usuario.setRol("ADMIN");
		 employees.setNomusuario("pimpommu");
		 employees.setPassword(encoder.encode("abs123"));;
		 employees.setRol("EDITOR");
		 Employees em = employeesRepository.save(employees);
		 assertEquals(em.getNomusuario(),employees.getNomusuario());
			
	}


}
