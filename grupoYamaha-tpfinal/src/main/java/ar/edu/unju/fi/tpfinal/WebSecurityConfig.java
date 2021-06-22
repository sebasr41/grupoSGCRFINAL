package ar.edu.unju.fi.tpfinal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import ar.edu.unju.fi.tpfinal.service.imp.UsuarioDetailServiceImp;


//import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationSuccessHandler autSuccessHandler;
	@Autowired
	UsuarioDetailServiceImp usuarioDetailService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
	//nuevo objeto de esa clase, osea objeto encriptado
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		// TODO Auto-generated method stub
		//la implementacion de user detail service que es un detalle que debe tener spring para construir esa implementacion
		auth.userDetailsService(usuarioDetailService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		//recursos permitidos
			.antMatchers("/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**","/layaout/**").permitAll()
			.antMatchers("/", "/login", "/index","/logout").permitAll()
			.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login")
		//.successHandler cuando el loggeo fue satisfactorio; maneja los permisos y indica a donde se va a dirigir
			.successHandler(autSuccessHandler)
			//en caso que falle el login
			.failureUrl("/login?error=true")
			.permitAll()				
		.and()
			.logout()
		 	.logoutUrl("logout")
			.logoutSuccessUrl("/login");//volver al login
			//http.csrf().disable();
		//super.configure(http);
	}	
}

