package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.ProductLine;

/**
 * IProductLinesService es una interfaz que permite minimizar el acompamiento entre clases
 * y tiene creado dentro de si los metodos Guardar, eliminar, listar y obtener, Optional,
 * de la clase ProductLine
*/
public interface IProductLinesService {
	
	/**
	 * Método guardar
	 * @param productLine
	 */
	public void guardarProductLines(ProductLine productLine);
	/**
	 * Método Eliminar, para la clase ProducLines
	 * @param id
	 */
	public void eliminarProductLines(String id);
	/**
	 * Método listar elemntos de Productline
	 * @return
	 */
	public List<ProductLine> obtenerProductLines();
	/**
	 * Método con la variable OPTIONAL
	 * (objeto podría o no encontrarse en un Set de Personas)
	 * @param id
	 * @return
	 */
	public Optional<ProductLine> getProductolinesPorId(String id);

}
