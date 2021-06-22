package ar.edu.unju.fi.tpfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tpfinal.service.imp.UsuarioDetailsServiceImp;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AutSuccessHandler autSuccessHandler;
	
	@Autowired
	UsuarioDetailsServiceImp usuarioDetailService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() { //->Esto permite cifrar las passwords
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDetailService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests() //->Acceso libre
				.antMatchers("/include/**","/css/**","icons/**","/img/**","/js/**","/layer/**","/webjars/**","/layouts/**").permitAll()
				.antMatchers("/","/logout").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login")
				.successHandler(autSuccessHandler) // asociamos la logica de redireccion
				.failureUrl("/login?error=true")
				.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout") //url de logout -> controller
				.logoutSuccessUrl("/logout");//pag de logout
				
		
	}
	
	
	
}
