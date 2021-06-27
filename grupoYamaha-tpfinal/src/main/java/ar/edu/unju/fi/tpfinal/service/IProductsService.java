package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Product;

/**
 * ICustomersService Esta interfaz permite minimizar el acomplamiento entre clases
 * y tiene creado dentro de si los metodos Guardar, eliminar, listar y obtener, Optional,
 * Listar y obtener de la clase Customer 
 */
public interface IProductsService{
    /**
     * Método guardar
     * @param products
     */
    public void guardarProducts(Product products);
    /**
     * Método Listar
     * @return
     */
    public List<Product> obtenerProducts();
    /**
     * Método elimianr
     * @param id
     */
	public void eliminarProducts(String id);
	/**
	 * Método de la variable OPTINAL
	 * @param id
	 * @return
	 */
	public Optional<Product> obtenerProductsPorId(String id);
	/**
	 * Método buscar
	 * @param productsName
	 * @param id
	 * @param price
	 * @return
	 */
    public Object buscarProducts(String productsName,String id, double price);
}
