package ar.edu.unju.fi.tpfinal.service;
/**
 * 
 * @author RCGS
 */
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Product;

public interface IProductsService{
    
    public void guardarProducts(Product products);
    
    public List<Product> obtenerProducts();
    
	public void eliminarProducts(String id);

	public Optional<Product> obtenerProductsPorId(String id);

    public Object buscarProducts(String productsName,String id, double price);
}
