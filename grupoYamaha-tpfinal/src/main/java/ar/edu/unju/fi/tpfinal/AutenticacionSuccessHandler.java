package ar.edu.unju.fi.tpfinal;
import java.io.IOException;
import java.util.Collection;
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
public class AutenticacionSuccessHandler  implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub		
		boolean esAdmin = false;
		boolean esEditor = false;
		//boolean tipoSocio = false;		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ADMIN")) {
				esAdmin = true;
				break;
			} else if(grantedAuthority.getAuthority().equals("CONSULTOR")) {
					esEditor = true;
					break;
			} 
		}
		if (esAdmin) {
			redirectStrategy.sendRedirect(request, response, "/empleados");
		} else if (esEditor) {
				redirectStrategy.sendRedirect(request, response, "/productlines");
		} else {
				throw new IllegalStateException();	
			}
		}					
}

	

