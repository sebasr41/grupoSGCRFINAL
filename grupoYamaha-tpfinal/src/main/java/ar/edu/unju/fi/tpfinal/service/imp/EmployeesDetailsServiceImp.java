package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Employees;
import ar.edu.unju.fi.tpfinal.repository.IEmployeesRepository;
import org.springframework.security.core.userdetails.User;

@Service
public class EmployeesDetailsServiceImp implements UserDetailsService{

	
	@Autowired
	IEmployeesRepository employeesRepository;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		// TODO Auto-generated method stub
	
		Employees employees = employeesRepository.findByNomusuario(username);
		UserBuilder builder = null;
		
		if(employees != null) {
			builder = User.withUsername(username);
			builder.password(employees.getPassword());
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
					roles.add(new SimpleGrantedAuthority(employees.getRol()));
					builder.authorities(roles);
		}else {
			throw new UsernameNotFoundException("usuario no encontrado");
		}
		return builder.build();
	}
}
