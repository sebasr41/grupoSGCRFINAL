package ar.edu.unju.fi.tpfinal;
/**
 * 
 * @author RCGS 
 *
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration ////implemento una interfaz WebMvcConfigurer
public class ImConfg implements WebMvcConfigurer {
//configuramos para que tome un directorio.Crreamos un metodo y
//agregamos addResourceHandlers, para agregar directorios o recursos a nuetsros proyecto
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		//reggystre(usamos para registrar nuestra ruta como directorio estatico).Utilizamos la misma que estara en nuestro html ->"/imagPvisual/**"
		registry.addResourceHandler("/imagPvisual/**").addResourceLocations("file:/home/mike47k/imagPvisual/");
		//lo segundo nuetsro directorio fisico "addResourceLocations" que significa agregar ubicaciones de recursos
	}
	
}