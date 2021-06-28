package ar.edu.unju.fi.tpfinal.config;
/**
 * 
 * @author RCGS 
 *
 */
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Contiene al metodo que actuara en caso de denegacion y nos devolvera a un html "forbidden"
 * clase que implemente AccessDeniedHandler (Controlador de acceso denegado) 
 *
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	/**
	 * Metodo para rediccionar la pagina en caso de acseso denegado
	 */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/forbidden");
    }
}
