package ar.edu.unju.fi.tpfinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Product;

//Es una interfaz que se extiende a los metodos de crudrepository y crea 
//metodos genericos de busqueda par ala entidad Product que tiene una clave primaria de tipo String
//ademas gestionar todas las operaciones de persistencia
//contra una tabla de la base de datos- 
public interface IProductRepository extends CrudRepository<Product,String> {
	
    List<Product> findByProductNameAndProductLinesProductLinesNameAndBuyPriceGreaterThanEqual(String productsName, String id,double price);
		
    List<Product> findByProductNameAndBuyPriceGreaterThanEqual(String id, double price);
	
    List<Product> findByBuyPriceGreaterThanEqual(double price);
	
    List<Product> findByProductLinesProductLinesNameAndBuyPriceGreaterThanEqual(String id, double price);

}
