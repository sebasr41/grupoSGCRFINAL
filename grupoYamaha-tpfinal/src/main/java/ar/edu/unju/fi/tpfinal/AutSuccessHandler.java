package ar.edu.unju.fi.tpfinal;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutSuccessHandler implements AuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy(); // -> Nos permite saber a donde nos va a redirigir

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		boolean esAdmin = false;
		boolean esEditor = false;
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("ADMIN")) {
				esAdmin = true;
				break;
			}else if (grantedAuthority.getAuthority().equals("EDITOR")) {
				esEditor = true;
				break;
			}
		}
		if(esAdmin) {
			redirectStrategy.sendRedirect(request, response, "/productlines");
		}else if(esEditor) {
			redirectStrategy.sendRedirect(request, response, "/products-list");
		} else {
			throw new IllegalStateException();
		}
	}
	
	
	
}
