package ar.edu.unju.fi.tpfinal;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//import ar.edu.unju.fi.tp6.service.imp.NomsuarioNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;

import ar.edu.unju.fi.tpfinal.service.imp.EmployeesDetailsServiceImp;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationSuccessHandler autSuccessHandler;
	
	@Autowired
	EmployeesDetailsServiceImp employeesDetailsServiceImp;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
	
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(employeesDetailsServiceImp).passwordEncoder(passwordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers("/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**","/layaout/**").permitAll()
			.antMatchers("/", "/login", "/index","/logout").permitAll()
			.antMatchers( "/","/empleados").hasAuthority("ADMIN")			
			.anyRequest().authenticated()
			.and()
		.formLogin().loginPage("/login")
			.successHandler(autSuccessHandler)
			.failureUrl("/login?error=true")
			.permitAll()
			.usernameParameter("nomusuario")
			.passwordParameter("password")				
			.and()
		.logout()
		 	.logoutUrl("logout")
			.permitAll()
			.logoutSuccessUrl("/login");
			//http.csrf().disable();
		super.configure(http);
	}
	
	
	

}